package cx.ath.jbzdak.spectrometric.util;

import cx.ath.jbzdak.spectrometric.api.SpectrometricResult;

import java.nio.IntBuffer;

/**
 * @author Jacek Bzdak jbzdak@gmail.com
 *         Date: Jan 20, 2010
 */
public class IntBufferResult implements SpectrometricResult{

   final int firstChannel, lastChannel;

   final IntBuffer contents;

   public IntBufferResult(IntBuffer contents, int firstChannel, int lastChannel) {
      this.contents = contents;
      this.firstChannel = firstChannel;
      this.lastChannel = lastChannel;
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

   @Override
   public int get(int channelNo) {
      return contents.get(channelNo - firstChannel);
   }
}
