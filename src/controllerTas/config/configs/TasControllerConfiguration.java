package controllerTas.config.configs;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 01/02/13
 */
public class TasControllerConfiguration {

   private PlatformConfig platformConfig;
   private ScaleConfig scaleConfig;
   private GnuplotConfig gnuplotConfig;

   public GnuplotConfig getGnuplotConfig() {
      return gnuplotConfig;
   }

   public void setGnuplotConfig(GnuplotConfig gnuplotConfig) {
      this.gnuplotConfig = gnuplotConfig;
   }

   public PlatformConfig getPlatformConfig() {
      return platformConfig;
   }

   public void setPlatformConfig(PlatformConfig platformConfig) {
      this.platformConfig = platformConfig;
   }

   public ScaleConfig getScaleConfig() {
      return scaleConfig;
   }

   public void setScaleConfig(ScaleConfig scaleConfig) {
      this.scaleConfig = scaleConfig;
   }

   @Override
   public String toString() {
      return "TasControllerConfiguration{" +
              "platformConfig=" + platformConfig +
              ", scaleConfig=" + scaleConfig +
              '}';
   }
}
