package controllerTas.Main;

import eu.cloudtm.wpm.connector.WPMConnector;
import eu.cloudtm.wpm.logService.remote.listeners.TestWPMViewChangeRemoteListenerImpl;
import eu.cloudtm.wpm.logService.remote.listeners.WPMViewChangeRemoteListener;

import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 31/01/13
 */
public class Main3 {

   public static void main(String args[]) throws NotBoundException, RemoteException, UnknownHostException {

      WPMConnector connector = new WPMConnector();

      WPMViewChangeRemoteListener viewChange = new TestWPMViewChangeRemoteListenerImpl(connector);

      connector.registerViewChangeRemoteListener(viewChange);

      while (true) {
      }

   }
}
