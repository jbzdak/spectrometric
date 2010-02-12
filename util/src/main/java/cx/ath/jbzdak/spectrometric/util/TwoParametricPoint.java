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

import cx.ath.jbzdak.spectrometric.api.MultiParametricPoint;

/**
 * @author Jacek Bzdak jbzdak@gmail.com
 *         Date: Jan 21, 2010
 */
public class TwoParametricPoint implements MultiParametricPoint{

   final int[] values = new int[2];

   public TwoParametricPoint(int v0, int v1) {
      this.values[0] = v0;
      this.values[1] = v1;
   }

   @Override
   public int getParameterCount() {
      return 2;
   }

   @Override
   public int getParameterValue(int paramNo) {
      return values[paramNo];
   }
}
