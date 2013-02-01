package controllerTas.controller;     /*
 * INESC-ID, Instituto de Engenharia de Sistemas e Computadores Investigação e Desevolvimento em Lisboa
 * Copyright 2013 INESC-ID and/or its affiliates and other
 * contributors as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a full listing of
 * individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3.0 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

/**
 * @author Diego Didona, didona@gsd.inesc-id.pt
 *         Date: 01/02/13
 */

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
