package controllerTas.controller;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 31/01/13
 */
public class Scale {

   private int numNodes;
   private int numThreads;

   public Scale(int numNodes, int numThreads) {
      this.numNodes = numNodes;
      this.numThreads = numThreads;
   }

   public int getNumNodes() {
      return numNodes;
   }

   public void setNumNodes(int numNodes) {
      this.numNodes = numNodes;
   }

   public int getNumThreads() {
      return numThreads;
   }

   public void setNumThreads(int numThreads) {
      this.numThreads = numThreads;
   }

   @Override
   public String toString() {
      return "ScaleConfig{" +
              "numNodes=" + numNodes +
              ", numThreads=" + numThreads +
              '}';
   }
}
