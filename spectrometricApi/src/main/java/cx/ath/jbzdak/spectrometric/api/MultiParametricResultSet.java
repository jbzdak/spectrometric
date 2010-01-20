package cx.ath.jbzdak.spectrometric.api;

import java.util.List;

/**
 * @author Jacek Bzdak jbzdak@gmail.com
 *         Date: Jan 20, 2010
 */
public interface MultiParametricResultSet {

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

   int getParameterNumber();

   List<MultiParametricPoint> getPoints();
}
