package controllerTas.config.configs;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 01/02/13
 */
public class GnuplotConfig {

   private String pathToData = "gnuplot/data/";
   private String pathToScript ="gnuplot/script/";
   private String pathToPlot= "gnuplot/plots/";
   private boolean eraseOldPlotsOnStartup = false;
   private String exec = "gnuplot";
   private String gnuplotScript = "plot.p";

   public String getExec() {
      return exec;
   }

   public void setExec(String exec) {
      this.exec = exec;
   }

   public String getGnuplotScript() {
      return gnuplotScript;
   }

   public void setGnuplotScript(String gnuplotScript) {
      this.gnuplotScript = gnuplotScript;
   }

   public String getPathToData() {
      return pathToData;
   }

   public void setPathToData(String pathToData) {
      this.pathToData = pathToData;
   }

   public boolean isEraseOldPlotsOnStartup() {
      return eraseOldPlotsOnStartup;
   }

   public void setEraseOldPlotsOnStartup(String eraseOldPlotsOnStartup) {
      this.eraseOldPlotsOnStartup = Boolean.valueOf(eraseOldPlotsOnStartup);
   }

   public String getPathToScript() {
      return pathToScript;
   }

   public void setPathToScript(String pathToScript) {
      this.pathToScript = pathToScript;
   }

   public String getPathToPlot() {
      return pathToPlot;
   }

   public void setPathToPlot(String pathToPlot) {
      this.pathToPlot = pathToPlot;
   }
}
