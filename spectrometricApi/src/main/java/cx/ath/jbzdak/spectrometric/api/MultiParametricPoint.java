package cx.ath.jbzdak.spectrometric.api;

/**
 * Point in multiparametric measurement.
 *
 * @author Jacek Bzdak jbzdak@gmail.com
 *         Date: Jan 20, 2010
 */
public interface MultiParametricPoint {

   int getParameterCount();

   int getParameterValue(int paramNo);

}
