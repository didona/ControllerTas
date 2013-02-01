package controllerTas.controller;

import controllerTas.config.configs.TasControllerConfiguration;

import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created with IntelliJ IDEA.
 * User: diego
 * Date: 30/01/13
 * Time: 11:58
 * To change this template use File | Settings | File Templates.
 */
public class TasControllerThread extends Thread {
   private TasControllerConfiguration config;

   public TasControllerThread(TasControllerConfiguration config) {
      this.config = config;
   }

   @Override
   public void run() {
      try {
         TasController tasController = new TasController(config);
      } catch (RemoteException e) {
         e.printStackTrace();
         System.exit(-1);
      } catch (UnknownHostException e) {
         e.printStackTrace();
         System.exit(-1);
      } catch (NotBoundException e) {
         e.printStackTrace();
         System.exit(-1);
      }
   }
}
