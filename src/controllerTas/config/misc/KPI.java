package controllerTas.config.misc;

import controllerTas.config.misc.Scale;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 01/02/13
 */
public class KPI {

   private Scale scale;
   private double throughput;
   private double abortProbability;
   private double rtt;

   public KPI(Scale scale, double throughput, double abortProbability, double rtt) {
      this.scale = scale;
      this.throughput = throughput;
      this.abortProbability = abortProbability;
      this.rtt = rtt;
   }

   public Scale getScale() {
      return scale;
   }

   public void setScale(Scale scale) {
      this.scale = scale;
   }

   public double getThroughput() {
      return throughput;
   }

   public void setThroughput(double throughput) {
      this.throughput = throughput;
   }

   public double getAbortProbability() {
      return abortProbability;
   }

   public void setAbortProbability(double abortProbability) {
      this.abortProbability = abortProbability;
   }

   public double getRtt() {
      return rtt;
   }

   public void setRtt(double rtt) {
      this.rtt = rtt;
   }

   @Override
   public String toString() {
      return "KPI{" +
              "scale=" + scale +
              ", throughput=" + throughput +
              ", abortProbability=" + abortProbability +
              ", rtt=" + rtt +
              '}';
   }
}
