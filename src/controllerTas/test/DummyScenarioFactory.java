package controllerTas.test;

import Tas2.core.ModelResult;
import Tas2.core.environment.DSTMScenarioTas2;
import Tas2.core.environment.WorkParams;
import Tas2.core.Tas2;
import Tas2.exception.Tas2Exception;
import Tas2.physicalModel.cpunet.cpu.CpuServiceTimes;
import Tas2.physicalModel.cpunet.cpu.two.CpuServiceTimes2Impl;
import Tas2.physicalModel.cpunet.net.queue.NetServiceTimes;
import Tas2.physicalModel.cpunet.net.tas.FixedRttServiceTimes;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 31/01/13
 */
public class DummyScenarioFactory {

   private static final Log log = LogFactory.getLog(DummyScenarioFactory.class);

   public void invoke() throws Tas2Exception {
      DSTMScenarioTas2 scenario = buildScenario();
      Tas2 tas = new Tas2();
      ModelResult result = tas.solve(scenario);
      log.trace("Invoked tas "+result.getMetrics().getThroughput());

   }

   public DSTMScenarioTas2 buildScenario() throws Tas2Exception {
    DSTMScenarioTas2 scenario = new DSTMScenarioTas2(buildCpuServiceTimes(),buildNetServiceTimes(),buildWorkloadParams());
     log.warn(scenario.toString());
      return scenario;
   }

   private WorkParams buildWorkloadParams() {

      WorkParams workParams = new WorkParams();
      workParams.setRetryOnAbort(true);
      workParams.setWriteOpsPerTx(1);
      workParams.setWritePercentage(1e-9);
      workParams.setLambda(0D);
      workParams.setPrepareMessageSize(4000);
      workParams.setNumNodes(5);
      workParams.setThreadsPerNode(3);
      workParams.setApplicationContentionFactor(1e-5);
      workParams.setMem(3E9);
      return workParams;
   }

   private CpuServiceTimes buildCpuServiceTimes() {


      CpuServiceTimes2Impl cpu = new CpuServiceTimes2Impl();
      cpu.setUpdateTxLocalExecutionS(1E5);
      cpu.setUpdateTxPrepareS(1E5);
      cpu.setUpdateTxCommitS(1E5);
      cpu.setUpdateTxLocalLocalRollbackS(1E5);
      cpu.setUpdateTxLocalRemoteRollbackS(1E5);

      cpu.setReadOnlyTxLocalExecutionS(100E6);
      cpu.setReadOnlyTxPrepareS(1E5);
      cpu.setReadOnlyTxCommitS(1E5);

      cpu.setUpdateTxRemoteExecutionS(1E5);
      cpu.setUpdateTxRemoteCommitS(1E5);
      cpu.setUpdateTxRemoteRollbackS(1E5);


      return cpu;
   }

   private NetServiceTimes buildNetServiceTimes() {
      return new FixedRttServiceTimes(1e6, 1e6);
   }

   public static void main(String args[]) throws Tas2Exception {
      new DummyScenarioFactory().invoke();
   }
}
