package cx.ath.jbzdak.twoParamConnector.api;

/**
 * Created by IntelliJ IDEA.
 * User: Jacek Bzdak jbzdak@gmail.com
 */
public class LinearFunctionFactory {
   private double a;
   private double b;

   public LinearFun create(){
      return new LinearFun(a,b);
   }


   public double getA() {
      return a;
   }

   public void setA(double a) {
      this.a = a;
   }

   public double getB() {
      return b;
   }

   public void setB(double b) {
      this.b = b;
   }
}
