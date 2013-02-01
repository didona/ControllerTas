package controllerTas.config.misc;

import java.util.Comparator;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 01/02/13
 */
public class LineComparator implements Comparator<PlottableDataLine> {

   @Override
   public int compare(PlottableDataLine plottableDataLine, PlottableDataLine plottableDataLine2) {
      Scale a = plottableDataLine.getScale();
      Scale b = plottableDataLine2.getScale();
      int aa = a.getNumNodes();
      int bb = b.getNumNodes();
      if (aa < bb)
         return -1;
      if (aa > bb)
         return 1;
      aa = a.getNumThreads();
      bb = b.getNumThreads();
      if (aa < bb)
         return -1;
      if (aa > bb)
         return 1;
      return 0;
   }
}
