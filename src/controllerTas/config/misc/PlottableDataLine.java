package controllerTas.config.misc;

import java.util.Arrays;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 01/02/13
 */
public class PlottableDataLine {

   private Scale scale;
   private double[] values;

   public PlottableDataLine(Scale scale, double... values) {
      this.scale = scale;
      this.values = values;
   }

   public Scale getScale() {
      return scale;
   }

   public void setScale(Scale scale) {
      this.scale = scale;
   }

   public double[] getValues() {
      return values;
   }

   public void setValues(double[] values) {
      this.values = values;
   }

   @Override
   public String toString() {
      return "PlottableDataLine{" +
              "scale=" + scale +
              ", values=" + Arrays.toString(values) +
              '}';
   }


   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      PlottableDataLine that = (PlottableDataLine) o;

      if (!scale.equals(that.scale)) return false;

      return true;
   }

   @Override
   public int hashCode() {
      int result = scale.hashCode();
      result = 31 * result + (values != null ? Arrays.hashCode(values) : 0);
      return result;
   }
}
