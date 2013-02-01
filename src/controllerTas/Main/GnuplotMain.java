package controllerTas.Main;

import controllerTas.config.TasControllerConfigurationFactory;
import controllerTas.config.configs.TasControllerConfiguration;
import controllerTas.config.misc.TasController;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 01/02/13
 */
public class GnuplotMain {

   public static void main(String args[]) throws Exception {
      PropertyConfigurator.configure("conf/log4j.properties");
      TasControllerConfiguration config = TasControllerConfigurationFactory.buildConfiguration("conf/controller.xml", "controllerTas.config.configs.");
      TasController t = new TasController(config);
      t.consumeStats(null, null);
   }
}
