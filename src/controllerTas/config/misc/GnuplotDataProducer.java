package controllerTas.config.misc;

import controllerTas.config.configs.GnuplotConfig;
import controllerTas.config.misc.Scale;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 01/02/13
 */
public class GnuplotDataProducer {

   private String path;
   private GnuplotConfig config;

   public GnuplotDataProducer(GnuplotConfig config) {
      this.config = config;
   }


}
