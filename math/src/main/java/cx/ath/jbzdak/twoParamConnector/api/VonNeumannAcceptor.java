package cx.ath.jbzdak.twoParamConnector.api;

import java.io.Serializable;

/**
 * @author Jacek Bzdak jbzdak@gmail.com
 *         Date: Feb 2, 2010
 */
public interface VonNeumannAcceptor extends Serializable{
   boolean accept(double rand, double check); 
}
