package controllerTas.controller;

import controllerTas.common.Scale;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 01/02/13
 */
public class ControllerState {

   private Scale currentScale;
   private AtomicBoolean maskInterrupt = new AtomicBoolean(false);
   private long lastReset = System.currentTimeMillis();

   public ControllerState(Scale currentScale) {
      this.currentScale = currentScale;
   }

   public Scale getCurrentScale() {
      return currentScale;
   }

   public void setCurrentScale(Scale currentScale) {
      this.currentScale = currentScale;
   }

   public long getLastTimeWindow(){
      long now = System.currentTimeMillis();
      long ret = now - lastReset;
      lastReset = now;
      return ret;
   }
}
