package controllerTas.config;


import Tas2.config.configs.Tas2Configuration;
import Tas2.config.xml.Tas2XmlParser;
import controllerTas.config.configs.TasControllerConfiguration;
import controllerTas.config.xml.TasControllerConfigXmlParser;

import java.io.IOException;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 11/10/12
 */
public class TasControllerConfigurationFactory {

   private static TasControllerConfiguration configuration;

   private TasControllerConfigurationFactory() {

   }

   public static TasControllerConfiguration getConfiguration() {
      return configuration;
   }

   protected static TasControllerConfigXmlParser buildXmlParser(String file, String packageName) {
      TasControllerConfigXmlParser parser = new TasControllerConfigXmlParser(file, packageName);
      return parser;
   }

   public static TasControllerConfiguration buildConfiguration(String file, String packageName) throws IOException {
      synchronized (Tas2.config.Tas2ConfigurationFactory.class) {
         if (configuration == null) {
            configuration = (TasControllerConfiguration) buildXmlParser(file, packageName).parseObject();
         }
      }
      return configuration;
   }
}
