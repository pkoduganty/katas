package net.jpmchase.mbt.tdd.fz;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * A FizzBuzz class with a String toString(int) method, valid inputs > 0. 
 * Returns "Fizz" if number is a multiple of 3 or has 3 in it, 
 * returns "Buzz" if number is a multiple of 5 or has 5 in it,
 * and returns "FizzBuzz" if number is a multiple of 3 and 5 or has both 3 and 5 in it. 
 * 
 * Create a trivial test with input toString(1) should return 1, run the test, should fail. 
 * Now, write code to make this test pass
 * Create test for toString(3) should print Fizz, run test, note failure and write code to pass this test.
 * Create test for multiples of 3, should print Fizz, run test, note failure and write code to pass this test. Refactor code.
 * Create test for multiples of 5, should print Buzz, run test, note failure and write code to pass this test. Refactor code.
 * Create test for multiples of 3 and 5, should print FizzBuzz, run test, note failure and write code to pass this test. Refactor code.
 * Extend to print "Fizz" if number is divisible by 3 or if it has a 3 in it
 * Extend to print "Buzz" if number is divisible by 5 or if it has a 5 in it
 * Extend to print "FizzBuzz" if number is divisible by 3 and 5 or if it has both 3 and 5
 */
public class FizzBuzzTest {
    private final FizzBuzz fz = new FizzBuzz();

    @Test
    public void testAddOne() {
        assertEquals("1", fz.toString(1));
    }

    @Test
    public void testAddThreeReturnFizz() {
        assertEquals("Fizz", fz.toString(3));
    }

    @Test
    public void testAddMultipleOfThreeReturnFizz() {
        assertEquals("Fizz", fz.toString(6));
    }

    @Test
    public void testAddFiveReturnBuzz() {
        assertEquals("Buzz", fz.toString(5));
    }

    @Test
    public void testAddMultipleOfFiveReturnBuzz() {
        assertEquals("Buzz", fz.toString(10));
    }

    @Test
    public void testAddMultipleOfThreeAndFiveReturnFizzBuzz() {
        assertEquals("FizzBuzz", fz.toString(15));
    }

    @Test
    public void testAddContainsThreeReturnFizz() {
        assertEquals("Fizz", fz.toString(13));
    }

    @Test
    public void testAddContainsFiveReturnBuzz() {
        assertEquals("Buzz", fz.toString(51));
    }

    @Test
    public void testAddContainsThreeAndFiveReturnFizzBuzz() {
        assertEquals("FizzBuzz", fz.toString(35));
        assertEquals("FizzBuzz", fz.toString(53));
        assertEquals("FizzBuzz", fz.toString(953));
    }
}
