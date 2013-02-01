package controllerTas.actions;

import Tas2.core.ModelResult;
import Tas2.core.Tas2;
import Tas2.core.environment.DSTMScenarioTas2;
import Tas2.exception.Tas2Exception;
import controllerTas.common.KPI;
import controllerTas.common.Scale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 01/02/13
 */
public class WhatIfAnalyzer {

   private int maxNodes;
   private int minNodes;
   private int minThreads;
   private int maxThreads;

   private final static Log log = LogFactory.getLog(WhatIfAnalyzer.class);

   public WhatIfAnalyzer(int minNodes, int maxNodes, int minThreads, int maxThreads) {
      this.maxNodes = maxNodes;
      this.minNodes = minNodes;
      this.minThreads = minThreads;
      this.maxThreads = maxThreads;
   }

   public Set<KPI> computeKPI(DSTMScenarioTas2 scenario) {
      Scale tempScale;
      ModelResult result;
      double throughput, abortP, rtt;
      Set<KPI> kpis = new HashSet<KPI>();
      for (int n = minNodes; n <= maxNodes; n++) {
         for (int t = minThreads; t <= maxThreads; t++) {
            scenario.getWorkParams().setNumNodes(n);
            scenario.getWorkParams().setThreadsPerNode(t);
            tempScale = new Scale(n, t);
            log.trace("Going to query for " + tempScale);
            try {
               result = new Tas2().solve(scenario);
               throughput = result.getMetrics().getThroughput();
               rtt = result.getMetrics().getPrepareRtt();
               abortP = (1.0D - result.getProbabilities().getPrepareProbability() * result.getProbabilities().getCoherProbability());
               log.info(tempScale + " throughput = " + throughput * 1e9 + ", rtt = " + rtt + ", abortProb = " + abortP);
               kpis.add(new KPI(tempScale, throughput, abortP, rtt));
            } catch (Tas2Exception e) {
               log.debug("The model did not converge for " + tempScale);
               log.info("TAS does not converge: throughput = 0, abortProb = 1.0");
            }
         }
      }
      return kpis;
   }

   @Override
   public String toString() {
      return "WhatIfAnalyzer{" +
              "maxNodes=" + maxNodes +
              ", minNodes=" + minNodes +
              ", minThreads=" + minThreads +
              ", maxThreads=" + maxThreads +
              '}';
   }
}