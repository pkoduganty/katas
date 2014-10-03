package net.jpmchase.mbt.tdd.fz;

/**
 * A FizzBuzz class with a String toString(int) method, valid inputs > 0. 
 * Returns "Fizz" if number is a multiple of 3 or has 3 in it, 
 * returns "Buzz" if number is a multiple of 5 or has 5 in it,
 * and returns "FizzBuzz" if number is a multiple of 3 and 5 or has both 3 and 5 in it. 
 */
public class FizzBuzz {

    public String toString(final int i) {
        if (isFizzBuzz(i)) {
            return "FizzBuzz";
        } else if (isBuzz(i)) {
            return "Buzz";
        } else if (isFizz(i)) {
            return "Fizz";
        } else {
            return Integer.toString(i);
        }
    }

    private boolean isFizz(final int i) {
        return i % 3 == 0 || Integer.toString(i).contains("3");
    }

    private boolean isBuzz(final int i) {
        return i % 5 == 0 || Integer.toString(i).contains("5");
    }

    private boolean isFizzBuzz(final int i) {
        return i % 15 == 0 || (Integer.toString(i).contains("3") && Integer.toString(i).contains("5"));
    }

    public static void main(final String[] args) {
        final FizzBuzz fz = new FizzBuzz();
        for (int i = 1; i <= 100; i++) {
            System.out.println(fz.toString(i));
        }
    }
}
