package controllerTas.actions.gnuplot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 01/02/13
 */
public class GnuplotExec {

   private String[] execCommand;
   private static final Log log = LogFactory.getLog(GnuplotExec.class);

   public GnuplotExec(String command, String script) {
      execCommand = new String[]{command, script};
   }

   public void exec() throws GnuplotException {
      try {
         Process p = Runtime.getRuntime().exec(execCommand);
         checkForError(p);
         p.destroy();
      } catch (Exception e) {
         throw new GnuplotException(e.getMessage());
      }
   }

   protected void checkForError(Process p) throws IOException, GnuplotException {
      BufferedReader stderr = new BufferedReader(new InputStreamReader(p.getErrorStream()));
      String read;

      StringBuilder errorString = new StringBuilder();
      boolean error = false;

      while ((read = stderr.readLine()) != null) {
         errorString.append(read);
         error = true;
      }

      if (error) {
         log.warn(errorString.toString());
         throw new GnuplotException((read));
      }
   }
}

