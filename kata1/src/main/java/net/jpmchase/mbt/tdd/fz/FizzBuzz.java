package net.jpmchase.mbt.tdd.fz;

/**
 * Create a FizzBuzz class with a String toString(int) method, valid inputs > 0. 
 * Returns "Fizz" if number is a multiple of 3 or has 3 in it, 
 * returns "Buzz" if number is a multiple of 5 or has 5 in it,
 * and returns "FizzBuzz" if number is a multiple of 3 and 5 or has both 3 and 5 in it. 
 */
public class FizzBuzz {

    public String toString(final int i) {
        //TODO
    }

    public static void main(final String[] args) {
        final FizzBuzz fz = new FizzBuzz();
        for (int i = 1; i <= 100; i++) {
            System.out.println(fz.toString(i));
        }
    }
}
