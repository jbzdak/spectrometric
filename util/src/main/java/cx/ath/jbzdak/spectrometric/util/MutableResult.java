package cx.ath.jbzdak.spectrometric.util;

import cx.ath.jbzdak.spectrometric.api.SpectrometricResult;

import java.nio.IntBuffer;

/**
 * @author Jacek Bzdak jbzdak@gmail.com
 *         Date: Jan 20, 2010
 */
public class MutableResult implements SpectrometricResult{

   final int firstChannel, lastChannel;

   final int[] contents;

   public MutableResult(int firstChannel, int lastChannel) {
      this.firstChannel = firstChannel;
      this.lastChannel = lastChannel;
      contents = new int[lastChannel - firstChannel];
   }

   public MutableResult(int[] contents, int firstChannel, int lastChannel) {
      this.contents = contents;
      this.firstChannel = firstChannel;
      this.lastChannel = lastChannel;
   }

   public SpectrometricResult createImmutableView(){
      return new IntBufferResult(IntBuffer.wrap(contents), firstChannel, lastChannel);
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