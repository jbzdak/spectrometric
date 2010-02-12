/*
 * Spectrometric api shared by Genie Connector and my various other programs.
 * Copyright (C) 2009 - 2010 Jacek Bzdak jbzdak@gmail.com
 *
 * This program was written for my BA in Faculty of Physics of
 * Warsaw University of Technology.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
