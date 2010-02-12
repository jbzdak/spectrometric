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

package cx.ath.jbzdak.spectrometric.api;

/**
 * @author Jacek Bzdak jbzdak@gmail.com
 *         Date: Jan 20, 2010
 */
public interface SpectrometricResult {

   /**
    *
    * @return First channel that is stored in this result.
    */
   int getFirstChannel();

    /**
    * @return First channel that is not stored in this result. Last channel has number
    * <code> getLastChannel - 1</code>
    */
   int getLastChannel();

   /**
    *
    * @return Number of channels
    */
   int getChannelNo();

   /**
    * Gets count in channel <code>channelNo</code>.
    * @param channelNo .
    * @return .
    * @throws IndexOutOfBoundsException When getting channel that is not a part of this result. 
    */
   int get(int channelNo);

   /**
    * Creates a Roi from this result.
    * @param startChannel first channel that is conutained in created roi
    * @param endChannel last channel that is conutained in created roi
    * @return created roi
    * @throws IndexOutOfBoundsException When roi would be wider than this instance
    */
   RegionOfInterest createROI(int startChannel, int endChannel);

   void dispose();
}
