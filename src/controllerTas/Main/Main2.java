package controllerTas.Main;

import eu.cloudtm.wpm.connector.WPMConnector;
import eu.cloudtm.wpm.logService.remote.events.SubscribeEvent;
import eu.cloudtm.wpm.logService.remote.listeners.TestWPMStatisticsRemoteListenerImpl;
import eu.cloudtm.wpm.logService.remote.listeners.WPMStatisticsRemoteListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 31/01/13
 */
public class Main2 {
   private static final Log log = LogFactory.getLog(Main2.class);

   public static void main(String args[]) throws NotBoundException, RemoteException, UnknownHostException {
      PropertyConfigurator.configure("conf/log4j.properties");
      log.trace("Going to create WpmConnector");
      WPMConnector connector = new WPMConnector();
      log.trace("Connector created");
      WPMStatisticsRemoteListener listener = new TestWPMStatisticsRemoteListenerImpl();//new TasWPMStatisticsRemoteListenerImpl();
      String[] VMs = new String[1];
      VMs[0] = "10.100.0.11";
      log.trace("Registering statisticRemoteListener for "+ Arrays.toString(VMs));
      connector.registerStatisticsRemoteListener(new SubscribeEvent(VMs), listener);
      while (true) {
      }
   }
}
