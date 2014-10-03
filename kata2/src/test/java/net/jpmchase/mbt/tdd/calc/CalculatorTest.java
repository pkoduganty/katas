package net.jpmchase.mbt.tdd.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Create a simple String calculator with method int add(String numbers). 
 * The method can take 0, 1 or 2 numbers, and will return their sum (for an empty string it will return 0). 
 * for example "" or "1" or "1,2"
 * 
 * Start with the simplest test case of an empty string
 * Handle 1 number
 * Handle 2 numbers delimited with comma
 * Handle an unknown amount of numbers
 * Handle new lines as delimiter between numbers (instead of commas). Ex. "1\n2,3" (will equal 6)
 * Support different delimiters, to change a delimiter, the beginning of the string will contain a separate line 
 *     that looks like this: "//[delimiter]\n[numbers..]" 
 *     for example "//;\n1;2" should return 3 where the default delimiter is ";". 
 *     The first line is optional, all existing scenarios should still be supported.
 * Delimiters can be of any length with the following format: "//[delimiter]\n" for example: "//ADD\n1ADD2ADD3" should return 6
 * Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2
 * Negative numbers will throw an exception "negatives not allowed: <number>". If there are multiple negatives, 
 *     show all of them in the exception message "negatives not allowed: <number1> <number2> <number3>"
 */
public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setup() {
        this.calculator = new Calculator();
    }

    @Test
    public void testAddEmptyOrWhitespace() {
        assertEquals(0, calculator.add(""));
        assertEquals(0, calculator.add(" \t\n"));
    }

    @Test
    public void testAddOneInt() {
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testAddTwoInts() {
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void testAddThreeInts() {
        assertEquals(6, calculator.add("1,2,3"));
    }

    @Test
    public void testAddIntsWithNewline() {
        assertEquals(3, calculator.add("1\n2"));
    }

    @Test
    public void testAddIntsWithCustomDelimiter() {
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    public void testAddIntsWithCustomLongDelimiter() {
        assertEquals(3, calculator.add("//add\n1add2"));
    }

    @Test
    public void testAddNumberGreaterThanThousand() {
        assertEquals(2, calculator.add("1001,2"));
    }

    @Test(expected = NumberFormatException.class)
    public void testAddNegative() {
        calculator.add("1,-2");
    }

    @Test
    public void testAddMultipleNegatives() {
        try {
            calculator.add("1,-2,3,-4");
        } catch (final RuntimeException e) {
            assertEquals("Invalid input: negatives not allowed: -2 -4", e.getMessage());
        }
    }

    @Test(expected = NumberFormatException.class)
    public void testAddInvalidChar() {
        calculator.add("1,a");
    }

    @Test
    public void testAddMultipleInvalidChars() {
        try {
            calculator.add("1,a,b,c");
        } catch (final RuntimeException e) {
            assertEquals("Invalid input: a b c", e.getMessage());
        }
    }
}
