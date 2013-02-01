package controllerTas.Main;

import controllerTas.config.TasControllerConfigurationFactory;
import controllerTas.config.configs.TasControllerConfiguration;
import controllerTas.controller.TasControllerThread;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;


/**
 * Created with IntelliJ IDEA.
 * User: diego
 * Date: 29/01/13
 * Time: 18:04
 * To change this template use File | Settings | File Templates.
 */
public class Main {
   private static final Log log = LogFactory.getLog(Main.class);

   public static void main(String[] args) throws IOException {
      PropertyConfigurator.configure("conf/log4j.properties");
      TasControllerConfiguration config = TasControllerConfigurationFactory.buildConfiguration("conf/controller.xml", "controllerTas.config.configs.");
      log.info("Startng TasController");
      TasControllerThread tasControllerThread = new TasControllerThread(config);
      try {
         tasControllerThread.start();
         log.info("TasController created. Now waiting for the magic.");
         tasControllerThread.join();
      } catch (InterruptedException e) {
         e.printStackTrace();
         System.exit(-1);
      }
      log.trace("I'm out :(");
   }

}
