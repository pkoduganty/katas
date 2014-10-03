package net.jpmchase.mbt.tdd.calc;

import java.util.ArrayList;
import java.util.List;

/**
 * Create a simple String calculator with a method int add(String numbers). 
 * The method can take 0, 1 or more numbers, and will return their sum. 
 */
public class Calculator {
    private static final int ZERO = 0;

    private static final int CALCULATOR_MAX_INT = 1000;

    private static final String DELIMITER_PREFIX = "//";

    private static final String DELIMITER_SUFFIX = "\n";

    private static final String DEFAULT_DELIMITERS = ",\n";

    public int add(final String input) {
        int sum = 0;
        final List<String> negativeNumbers = new ArrayList<String>(), invalidNumbers = new ArrayList<String>();
        for (final String number : parse(input)) {
            try {
                sum += parseInteger(number);
            } catch (final NumberFormatException nfe) {
                invalidNumbers.add(number);
            } catch (final IllegalArgumentException neg) {
                negativeNumbers.add(number);
            }
        }

        if (negativeNumbers.isEmpty() && invalidNumbers.isEmpty()) {
            return sum;
        } else {
            throwInvalidInputException(negativeNumbers, invalidNumbers);
            return sum;
        }
    }

    private void throwInvalidInputException(final List<String> negativeNumbers, final List<String> invalidNumbers)
            throws NumberFormatException {
        final StringBuilder errorMessageBuilder = new StringBuilder("Invalid input: ");
        for (final String n : invalidNumbers) {
            errorMessageBuilder.append(n).append(" ");
        }

        if (negativeNumbers.size() > 0) {
            errorMessageBuilder.append("negatives not allowed: ");
            for (final String n : negativeNumbers) {
                errorMessageBuilder.append(n).append(" ");
            }
        }
        throw new NumberFormatException(errorMessageBuilder.toString().trim());
    }

    private String[] parse(final String input) {
        String delimiters = DEFAULT_DELIMITERS;
        if (input.startsWith(DELIMITER_PREFIX) && input.contains(DELIMITER_SUFFIX)) {
            delimiters = DEFAULT_DELIMITERS
                    + input.substring(DELIMITER_PREFIX.length(), input.indexOf(DELIMITER_SUFFIX));
        }
        final String numbers = input.startsWith(DELIMITER_PREFIX) ? input.substring(input.indexOf(DELIMITER_SUFFIX))
                : input;
        return numbers.split("[" + delimiters + "]");
    }

    private int parseInteger(final String str) {
        if (isEmptyString(str)) {
            return ZERO;
        }

        final int number = Integer.parseInt(str);
        if (number > CALCULATOR_MAX_INT) {
            return ZERO;
        } else if (number < ZERO) {
            throw new IllegalArgumentException(str);
        } else {
            return number;
        }
    }

    private boolean isEmptyString(final String s) {
        return null == s || s.trim().isEmpty();
    }
}
