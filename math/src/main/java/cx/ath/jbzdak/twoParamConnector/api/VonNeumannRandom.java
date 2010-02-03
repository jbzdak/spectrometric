package cx.ath.jbzdak.twoParamConnector.api;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author Jacek Bzdak jbzdak@gmail.com
 *         Date: Feb 2, 2010
 */
public class VonNeumannRandom extends Random{

   private final Random random;

   private final VonNeumannAcceptor acceptor;

   public VonNeumannRandom(VonNeumannAcceptor acceptor) {
      this.random = new SecureRandom();
      this.acceptor = acceptor;
   }

   public VonNeumannRandom(VonNeumannAcceptor acceptor, Random random) {
      this.acceptor = acceptor;
      this.random = random;
   }

   @Override
   public double nextDouble() {
      double rand;
      double check;
      do{
         rand = random.nextDouble();
         check = random.nextDouble();
      }while (acceptor.accept(rand, check));
      return rand;
   }

   @Override
   public float nextFloat() {
      return (float) nextDouble();
   }

   @Override
   public int nextInt() {
      int rand;
      int check;
      do{
         rand = random.nextInt();
         check = random.nextInt();
      }while (acceptor.accept(rand, check));
      return rand;
   }

   @Override
   public int nextInt(int n) {
      return super.nextInt(n);
   }

   @Override
   public long nextLong() {
      return super.nextLong();
   }
}
