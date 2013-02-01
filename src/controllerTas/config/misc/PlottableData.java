package controllerTas.config.misc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 01/02/13
 */
public class PlottableData {

   private String header; //Can be null
   private Set<PlottableDataLine> lines = new HashSet<PlottableDataLine>();
   private final static Log log = LogFactory.getLog(PlottableData.class);

   public PlottableData(String header, HashSet<PlottableDataLine> lines) {
      this.header = header;
      this.lines.addAll(lines);
   }

   public PlottableData(String header) {
      this.header = header;
   }

   public void setHeader(String header) {
      this.header = header;
   }

   public void setLines(SortedSet<PlottableDataLine> lines) {
      this.lines = lines;
   }

   public void addDataLine(PlottableDataLine line) {
      this.lines.add(line);
      log.trace(lines);
   }

   public String getHeader() {
      return header;
   }

   public Set<PlottableDataLine> getLines() {
      return lines;
   }
}
