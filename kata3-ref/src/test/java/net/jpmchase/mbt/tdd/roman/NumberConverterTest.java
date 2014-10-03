package net.jpmchase.mbt.tdd.roman;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * NumberConverter class with method {@link #toRomanNumeral(int)} to convert number (between 1 and 3000) 
 * to its roman numeral form. Used the below table to incrementally arrive at the conversion algorithm. 
 * Roman = Integer  
 *  I    = 1  
 *  II   = 2  
 *  III  = 3  
 *  IV   = 4  
 *  V    = 5  
 *  VII  = 7  
 *  IX   = 9  
 *  X    = 10  
 *  XI   = 11  
 *  XIV  = 14  
 *  XV   = 15  
 *  XVIII= 18  
 *  XIX  = 19  
 *  XX   = 20  
 *  XL   = 40  
 *  L    = 50  
 *  XC   = 90  
 *  C    = 100  
 *  CD   = 400  
 *  D    = 500
 *  CM   = 900  
 *  M    = 1000 
 */
public class NumberConverterTest {
    private NumberConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new NumberConverter();
    }

    @Test
    public void testConvertOneTwoThree() {
        assertEquals("I", converter.toRomanNumeral(1));
        assertEquals("II", converter.toRomanNumeral(2));
        assertEquals("III", converter.toRomanNumeral(3));
    }

    @Test
    public void testConvertFiveSixSeven() {
        assertEquals("V", converter.toRomanNumeral(5));
        assertEquals("VI", converter.toRomanNumeral(6));
        assertEquals("VII", converter.toRomanNumeral(7));
    }

    @Test
    public void testConvertFourNine() {
        assertEquals("IV", converter.toRomanNumeral(4));
        assertEquals("IX", converter.toRomanNumeral(9));
    }

    @Test
    public void testConvertTenEleven() {
        assertEquals("X", converter.toRomanNumeral(10));
        assertEquals("XI", converter.toRomanNumeral(11));
    }

    @Test
    public void testConvertFourteenFifteenEighteenNineteenTwenty() {
        assertEquals("XIV", converter.toRomanNumeral(14));
        assertEquals("XV", converter.toRomanNumeral(15));
        assertEquals("XVIII", converter.toRomanNumeral(18));
        assertEquals("XIX", converter.toRomanNumeral(19));
        assertEquals("XX", converter.toRomanNumeral(20));
    }

    @Test
    public void testConvertFiftyForty() {
        assertEquals("L", converter.toRomanNumeral(50));
        assertEquals("XL", converter.toRomanNumeral(40));
    }

    @Test
    public void testConvertLargeNumbers() {
        assertEquals("CDXLVIII", converter.toRomanNumeral(448));
        assertEquals("MCMXC", converter.toRomanNumeral(1990));
        assertEquals("MMVIII", converter.toRomanNumeral(2008));
    }

}
