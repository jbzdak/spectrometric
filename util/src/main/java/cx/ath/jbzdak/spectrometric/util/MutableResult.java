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

import cx.ath.jbzdak.spectrometric.api.SpectrometricResult;

import java.nio.IntBuffer;
import java.security.InvalidParameterException;

/**
 * @author Jacek Bzdak jbzdak@gmail.com
 *         Date: Jan 20, 2010
 */
public class MutableResult extends AbstractSpectrometricResult{

   final int[] contents;

   public MutableResult(int firstChannel, int lastChannel, int[] contents) {
      super(firstChannel, lastChannel);
      if(contents.length < (lastChannel - firstChannel)){
         throw new InvalidParameterException("Contents array is to small");
      }
      this.contents = contents;
   }

   public MutableResult(int firstChannel, int lastChannel) {
      super(firstChannel, lastChannel);
      contents = new int[lastChannel - firstChannel];
   }

   public SpectrometricResult createImmutableView(){
      return new IntBufferResult(firstChannel, lastChannel, IntBuffer.wrap(contents));
   }

   @Override
   public int getFirstChannel() {
      return firstChannel;
   }

   @Override
   public int getLastChannel() {
      return lastChannel;
   }

   @Override
   public void dispose() { }

   @Override
   public int getChannelNo() {
      return lastChannel - firstChannel;
   }

   public void clear(){
      for (int ii = 0; ii < contents.length; ii++) {
         contents[ii] =0;
      }
   }

   @Override
   public int get(int channelNo) {
      return contents[channelNo - firstChannel];
   }

   public void incrementChannel(int channelNo){
      contents[channelNo - firstChannel]++;
   }

   public void setValue(int channelNo){
      contents[channelNo - firstChannel] = channelNo;
   }

   public int[] getContents() {
      return contents;
   }
}