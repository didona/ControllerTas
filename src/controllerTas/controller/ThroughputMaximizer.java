package controllerTas.controller;

import Tas2.core.ModelResult;
import Tas2.core.environment.DSTMScenarioTas2;
import Tas2.exception.Tas2Exception;
import Tas2.core.Tas2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 31/01/13
 */
public class ThroughputMaximizer {

   private int maxNodes;
   private int minNodes;
   private int minThreads;
   private int maxThreads;

   private final DSTMScenarioFactory factory = new DSTMScenarioFactory();

   private final static Log log = LogFactory.getLog(ThroughputMaximizer.class);

   public ThroughputMaximizer(int minNodes, int maxNodes, int minThreads, int maxThreads) {
      this.maxNodes = maxNodes;
      this.minNodes = minNodes;
      this.minThreads = minThreads;
      this.maxThreads = maxThreads;
   }

   public Scale computeMaxThroughputScale(DSTMScenarioTas2 scenario) throws Tas2Exception {

      ModelResult result;
      Scale optScale = null, tempScale;
      double maxTh = 0, tempTh;
      //TODO scenario should be cloned
      for (int n = minNodes; n <= maxNodes; n++) {
         for (int t = minThreads; t <= maxThreads; t++) {
            scenario.getWorkParams().setNumNodes(n);
            scenario.getWorkParams().setThreadsPerNode(t);
            tempScale = new Scale(n, t);
            log.trace("Going to query for "+tempScale);
            try {
               result = new Tas2().solve(scenario);
               tempTh = result.getMetrics().getThroughput();
               log.info(tempScale+" throughput = " +tempTh*1e9 + ", rtt = "+result.getMetrics().getPrepareRtt()+", abortProb = "+(1.0D - result.getProbabilities().getPrepareProbability() * result.getProbabilities().getCoherProbability()));
               if (tempTh > maxTh) {
                  optScale = tempScale;
                  maxTh = tempTh;
               }
            } catch (Tas2Exception e) {
               log.debug("The model did not converge for " + tempScale);
               log.info("TAS does not converge: throughput = 0, abortProb = 1.0");
            }
         }
      }
      if (optScale == null) {
         throw new Tas2Exception("The model never converges");
      }
      return optScale;
   }

}
