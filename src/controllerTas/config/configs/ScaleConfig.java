package controllerTas.config.configs;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 01/02/13
 */
public class ScaleConfig {

   private int minNumNodes = 2;
   private int maxNumNodes = 10;
   private int minNumThreads = 2;
   private int maxNumThreads = 8;
   private int initNumNodes = 2;
   private int initNumThreads = 2;

   public int getInitNumNodes() {
      return initNumNodes;
   }

   public void setInitNumNodes(int initNumNodes) {
      this.initNumNodes = initNumNodes;
   }

   public int getInitNumThreads() {
      return initNumThreads;
   }

   public void setInitNumThreads(int initNumThreads) {
      this.initNumThreads = initNumThreads;
   }

   public int getMinNumNodes() {
      return minNumNodes;
   }

   public void setMinNumNodes(int minNumNodes) {
      this.minNumNodes = minNumNodes;
   }

   public int getMaxNumNodes() {
      return maxNumNodes;
   }

   public void setMaxNumNodes(int maxNumNodes) {
      this.maxNumNodes = maxNumNodes;
   }

   public int getMinNumThreads() {
      return minNumThreads;
   }

   public void setMinNumThreads(int minNumThreads) {
      this.minNumThreads = minNumThreads;
   }

   public int getMaxNumThreads() {
      return maxNumThreads;
   }

   public void setMaxNumThreads(int maxNumThreads) {
      this.maxNumThreads = maxNumThreads;
   }

   @Override
   public String toString() {
      return "ScaleConfig{" +
              "minNumNodes=" + minNumNodes +
              ", maxNumNodes=" + maxNumNodes +
              ", minNumThreads=" + minNumThreads +
              ", maxNumThreads=" + maxNumThreads +
              ", initNumNodes=" + initNumNodes +
              ", initNumThreads=" + initNumThreads +
              '}';
   }


}
