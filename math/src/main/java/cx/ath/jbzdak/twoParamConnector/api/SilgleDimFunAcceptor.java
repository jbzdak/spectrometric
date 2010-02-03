package cx.ath.jbzdak.twoParamConnector.api;

/**
 * @author Jacek Bzdak jbzdak@gmail.com
 *         Date: Feb 2, 2010
 */
public class SilgleDimFunAcceptor implements VonNeumannAcceptor{

   final SingleDimFunction function;

   public SilgleDimFunAcceptor(SingleDimFunction function) {
      this.function = function;
   }

   @Override
   public boolean accept(double rand, double check) {
      return rand <= function.compute(check);
   }
}
