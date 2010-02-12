/*
 * Spectrometric api shared by Genie Connector and my various other programs.
 * Copyright (C) 2009 - 2010 Jacek Bzdak jbzdak@gmail.com
 *
 * This program was written for my BA in Faculty of Physics of
 * Warsaw University of Technology.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package cx.ath.jbzdak.spectrometric.util;

import cx.ath.jbzdak.spectrometric.api.RegionOfInterest;
import cx.ath.jbzdak.spectrometric.api.SpectrometricResult;

/**
 * @author Jacek Bzdak jbzdak@gmail.com
 *         Date: 2010-02-12
 */
public abstract class AbstractSpectrometricResult implements SpectrometricResult{


   protected final int firstChannel, lastChannel;

   protected AbstractSpectrometricResult(int firstChannel, int lastChannel) {
      this.firstChannel = firstChannel;
      this.lastChannel = lastChannel;
   }

   @Override
   public RegionOfInterest createROI(int startChannel, int endChannel) {
      if(startChannel < this.firstChannel || endChannel > this.lastChannel){
         throw new IndexOutOfBoundsException();
      }
      return new ROIImpl(startChannel, endChannel, this);
   }
}
