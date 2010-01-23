package cx.ath.jbzdak.twoParamConnector.api;

/**
 * Created by IntelliJ IDEA.
 * User: Jacek Bzdak jbzdak@gmail.com
 */
public interface SingleDimFunction {
    /**
     * Returns function value for given argument
     * @param x function argument
     * @return function value
     */
    double compute(double x);

    /**
     * Returns function that is inverse of this function
     * @return inverse function
     * @throws UnsupportedOperationException if there is no inverse function
     */
    SingleDimFunction inverse() throws UnsupportedOperationException;
}
