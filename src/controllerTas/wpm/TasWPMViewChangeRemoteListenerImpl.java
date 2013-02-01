package controllerTas.wpm;

import controllerTas.controller.TasController;
import eu.cloudtm.wpm.connector.WPMConnector;
import eu.cloudtm.wpm.logService.remote.events.PublishViewChangeEvent;
import eu.cloudtm.wpm.logService.remote.events.SubscribeEvent;
import eu.cloudtm.wpm.logService.remote.listeners.WPMStatisticsRemoteListener;
import eu.cloudtm.wpm.logService.remote.listeners.WPMViewChangeRemoteListener;
import eu.cloudtm.wpm.logService.remote.observables.Handle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.rmi.RemoteException;
import java.util.Arrays;

public class TasWPMViewChangeRemoteListenerImpl implements
        WPMViewChangeRemoteListener {

   private WPMConnector connector;
   private final static Log log = LogFactory.getLog(TasWPMViewChangeRemoteListenerImpl.class);
   private Handle lastVmHandle;
   private TasController tasController;

   public TasWPMViewChangeRemoteListenerImpl(WPMConnector connector, TasController tasController) {
      this.connector = connector;
      this.tasController = tasController;
   }

   @Override
   public void onViewChange(PublishViewChangeEvent event)
           throws RemoteException {

      if (lastVmHandle != null) {
         log.trace("Removing last handle");
         connector.removeStatisticsRemoteListener(lastVmHandle);
         lastVmHandle = null;
      }
      String[] VMs = event.getCurrentVMs();

      if (VMs == null) {
         log.trace("The set of VMs is empty. No-op");
         return;
      }

      WPMStatisticsRemoteListener listener = new TasWPMStatisticsRemoteListenerImpl(tasController);

      log.trace("New set of VMs " + Arrays.toString(VMs));

      lastVmHandle = connector.registerStatisticsRemoteListener(new SubscribeEvent(VMs), listener);
   }


}
