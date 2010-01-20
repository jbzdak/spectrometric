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
    */
   int get(int channelNo);

   void dispose();
}
