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

import javax.annotation.concurrent.Immutable;

import cx.ath.jbzdak.spectrometric.api.RegionOfInterest;
import cx.ath.jbzdak.spectrometric.api.SpectrometricResult;

/**
 * @author Jacek Bzdak jbzdak@gmail.com
 *         Date: 2010-02-12
 */
@Immutable
public class ROIImpl extends AbstractSpectrometricResult implements RegionOfInterest {

   private final SpectrometricResult parent;

   public ROIImpl(int firstChannel, int lastChannel, SpectrometricResult parent) {
      super(firstChannel, lastChannel);
      this.parent = parent;
   }

   public SpectrometricResult getParent() {
      return parent;
   }

   public int getFirstChannel() {
      return firstChannel;
   }

   public int getLastChannel() {
      return lastChannel;
   }

   @Override
   public int getChannelNo() {
      return lastChannel - firstChannel;
   }

   @Override
   public int get(int channelNo) {
      if(channelNo > lastChannel || channelNo < firstChannel){
         throw new IndexOutOfBoundsException();
      }
      return parent.get(channelNo);
   }

   @Override
   public RegionOfInterest createROI(int startChannel, int endChannel) {
      if(startChannel < this.firstChannel || endChannel > this.lastChannel){
         throw new IndexOutOfBoundsException();
      }
      return new ROIImpl(startChannel, endChannel, parent);
   }
   
   @Override
   public void dispose() {  }
}
