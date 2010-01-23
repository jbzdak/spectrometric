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
