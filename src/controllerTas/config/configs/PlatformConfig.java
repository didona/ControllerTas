package controllerTas.config.configs;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 01/02/13
 */
public class PlatformConfig {

   private int numCores = 8;

   public int getNumCores() {
      return numCores;
   }

   public void setNumCores(int numCores) {
      this.numCores = numCores;
   }

   @Override
   public String toString() {
      return "PlatformConfig{" +
              "numCores=" + numCores +
              '}';
   }
}
