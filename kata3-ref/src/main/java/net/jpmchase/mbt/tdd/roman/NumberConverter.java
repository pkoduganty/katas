package net.jpmchase.mbt.tdd.roman;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * A NumberConverter class with method {@link #toRomanNumeral(int)} to convert number (between 1 and 3000) 
 * to its roman numeral form. 
 */
public class NumberConverter {
    private final Map<Integer, String> symbolTable;

    NumberConverter() {
        symbolTable = new TreeMap<Integer, String>(Collections.reverseOrder());
        symbolTable.put(1, "I");
        symbolTable.put(4, "IV");
        symbolTable.put(5, "V");
        symbolTable.put(9, "IX");
        symbolTable.put(10, "X");
        symbolTable.put(40, "XL");
        symbolTable.put(50, "L");
        symbolTable.put(90, "XC");
        symbolTable.put(100, "C");
        symbolTable.put(400, "CD");
        symbolTable.put(500, "D");
        symbolTable.put(900, "CM");
        symbolTable.put(1000, "M");
    }

    public String toRomanNumeral(int number) {
        final StringBuilder result = new StringBuilder();
        for (final Map.Entry<Integer, String> symbol : symbolTable.entrySet()) {
            //System.out.println("Key:" + symbol.getKey() + ", Value:" + symbol.getValue());

            while (number >= symbol.getKey()) {
                result.append(symbol.getValue());
                number -= symbol.getKey();
            }
        }

        return result.toString();
    }
}
