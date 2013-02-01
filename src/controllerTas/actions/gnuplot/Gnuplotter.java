package controllerTas.actions.gnuplot;

import controllerTas.common.KPI;

import java.util.Set;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 01/02/13
 */
public interface Gnuplotter {

   public void plot(Set<KPI> kpis) throws GnuplotException;
}
