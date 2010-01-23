package cx.ath.jbzdak.twoParamConnector.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinearFun implements SingleDimFunction{
	
	private final double a,b;

   private final double sigmaA, sigmaB;

   private static final Pattern pattern = Pattern.compile("\\s*([-+]?\\s*[\\d\\.\\,]+)\\s*\\*?\\s*x\\s*([+-]\\s*[\\d\\.\\,]+)");

   public static LinearFun parseFromHumanFormat(String parseFrom){
      parseFrom = parseFrom.replaceAll("\\,", ".");
      Matcher m = pattern.matcher(parseFrom);
      if(!m.matches()){
         throw new IllegalArgumentException("Bad format of LinearFun string");
      }
      return new LinearFun(Double.parseDouble(m.group(1)), Double.parseDouble(m.group(2)));
   }
	
	public LinearFun() {
		this(1,0);
	}

	public LinearFun(double a, double b) {
		super();
		this.a = a;
		this.b = b;
      this.sigmaA = 0;
      this.sigmaB = 0;
	}

   public LinearFun(double a, double b, double sigmaA, double sigmaB) {
      this.a = a;
      this.b = b;
      this.sigmaA = sigmaA;
      this.sigmaB = sigmaB;
   }

   @Override
	public double compute(double x){
		return a*x + b;
	}

   public double getSigna(double x){
      return sigmaA*x + sigmaB;
   }

    @Override
	public LinearFun inverse(){
		return new LinearFun(1/a, -b/a);
	}

   public double getA() {
      return a;
   }

   public double getB() {
      return b;
   }

   public double getSigmaA() {
      return sigmaA;
   }

   public double getSigmaB() {
      return sigmaB;
   }

   public LinearFunctionFactory createFactory(){
      LinearFunctionFactory linearFunctionFactory = new LinearFunctionFactory();
      linearFunctionFactory.setA(a);
      linearFunctionFactory.setB(b);
      return linearFunctionFactory;
   }

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder();
      sb.append("LinearFun");
      sb.append("{a=").append(a);
      sb.append(", b=").append(b);
      sb.append(", sigmaA=").append(sigmaA);
      sb.append(", sigmaB=").append(sigmaB);
      sb.append('}');
      return sb.toString();
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      LinearFun linearFun = (LinearFun) o;

      if (Double.compare(linearFun.a, a) != 0) return false;
      if (Double.compare(linearFun.b, b) != 0) return false;

      return true;
   }

   @Override
   public int hashCode() {
      int result;
      long temp;
      temp = a != +0.0d ? Double.doubleToLongBits(a) : 0L;
      result = (int) (temp ^ (temp >>> 32));
      temp = b != +0.0d ? Double.doubleToLongBits(b) : 0L;
      result = 31 * result + (int) (temp ^ (temp >>> 32));
      return result;
   }
}
