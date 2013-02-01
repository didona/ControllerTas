package controllerTas.config.misc;

import Tas2.core.environment.DSTMScenarioTas2;
import Tas2.exception.Tas2Exception;
import controllerTas.config.configs.TasControllerConfiguration;
import controllerTas.test.DummyScenarioFactory;
import controllerTas.wpm.TasWPMViewChangeRemoteListenerImpl;
import eu.cloudtm.wpm.connector.WPMConnector;
import eu.cloudtm.wpm.logService.remote.events.PublishAttribute;
import eu.cloudtm.wpm.logService.remote.listeners.WPMViewChangeRemoteListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created with IntelliJ IDEA.
 * User: diego
 * Date: 29/01/13
 * Time: 19:03
 * To change this template use File | Settings | File Templates.
 */
public class TasController {

   private WPMConnector connector;
   private static final Log log = LogFactory.getLog(TasController.class);
   private AtomicBoolean maskInterrupt = new AtomicBoolean(false);
   private ThroughputMaximizer throughputMaximizer;
   private WhatIfAnalyzer analyzer;
   private DSTMScenarioFactory factory = new DummyScenarioFactory();//new DSTMScenarioFactory();
   private ControllerState state;

   private TasControllerConfiguration config;

   public TasController(TasControllerConfiguration conf) throws RemoteException, UnknownHostException, NotBoundException {
      this.config = conf;
      init(this.config);
      log.info("TasController created: Going to create the WPMConnector for it");
      connector = new WPMConnector();
      log.info("WPMConnector created. Attaching the viewChangeRemoteListener");
      WPMViewChangeRemoteListener viewChange = new TasWPMViewChangeRemoteListenerImpl(connector, this);
      connector.registerViewChangeRemoteListener(viewChange);
      log.info("TasController is set up");
      while (true) {
         break;
      }
   }


   private void init(TasControllerConfiguration config) {
      log.trace("Creating TasController with configuration:\n" + config);
      int minN = config.getScaleConfig().getMinNumNodes();
      int maxN = config.getScaleConfig().getMaxNumNodes();
      int minT = config.getScaleConfig().getMinNumThreads();
      int maxT = config.getScaleConfig().getMaxNumThreads();
      this.throughputMaximizer = new ThroughputMaximizer(minN, maxN, minT, maxT);
      this.analyzer = new WhatIfAnalyzer(minN, maxN, minT, maxT);

      int initN = config.getScaleConfig().getInitNumNodes();
      int initT = config.getScaleConfig().getInitNumThreads();
      Scale initScale = new Scale(initN, initT);

      this.state = new ControllerState(initScale);

   }

   public void consumeStats(Set<HashMap<String, PublishAttribute>> jmx, Set<HashMap<String, PublishAttribute>> mem) throws PublishAttributeException, Tas2Exception {

      if (maskInterrupt.compareAndSet(false, true)) {
         try {
            double timeWindow = state.getLastTimeWindow() / 1e3;
            log.info("Consuming stats relevant to the last " + timeWindow + " sec");
            DSTMScenarioTas2 scenario = factory.buildScenario(jmx, mem, timeWindow, state.getCurrentScale().getNumThreads());
            log.trace("BuiltScenario\n" + scenario.toString());
            Set<KPI> kpis = analyzer.computeKPI(scenario);
            System.out.println("KPIs "+kpis.toString());
            ThroughputPlotter gnu = new ThroughputPlotter(config.getGnuplotConfig());
            gnu.plot(kpis);
            //this.throughputMaximizer.computeMaxThroughputScale(scenario);
         } catch (Tas2Exception t) {
            log.warn(t);
            log.trace(Arrays.toString(t.getStackTrace()));
            log.trace("Skipping");
         }
         catch (GnuplotException g){
            log.warn(g.getMessage());
         }
         finally {
            log.trace("Resetting maskInterrupt");
            maskInterrupt.set(false);
         }
      } else {
         log.trace("Masked interrupt");
      }
   }

}
