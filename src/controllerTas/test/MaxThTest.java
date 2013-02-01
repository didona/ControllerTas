package controllerTas.test;

import Tas2.exception.Tas2Exception;
import controllerTas.config.misc.ThroughputMaximizer;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 31/01/13
 */
public class MaxThTest {


   public static void main(String args[]) throws Tas2Exception {
      PropertyConfigurator.configure("conf/log4j.properties");
      ThroughputMaximizer throughputMaximizer = new ThroughputMaximizer(2,10,3,3);
      DummyScenarioFactory dummyScenarioFactory = new DummyScenarioFactory();
      System.out.println("MaxTh "+throughputMaximizer.computeMaxThroughputScale(dummyScenarioFactory.buildScenario()));
   }
}
