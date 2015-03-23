/**
 *
 */
package com.example.merchant;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author sarvex
 */
public class Roman {

    private static final Integer ZERO = Integer.valueOf(0);
    private static final Integer ONE = Integer.valueOf(1);
    private static final Integer MAX = Integer.valueOf(3);

    /**
     * Method to convert roman numeric to it's equivalent decimal
     *
     * @param roman
     * @return
     */
    public static int toDecimal(String roman) {

        int number = 0;
        int previous = 0;
        int digit = 0;

        for (final char romanit : new StringBuilder(roman.toUpperCase()).reverse().toString().toCharArray()) {

            Roman.count(Character.valueOf(romanit));

            digit = Roman.getValue(romanit);

            if ((previous > digit) && Roman.isSubtractable(digit, previous)) {
                number -= digit;
            } else {
                number += digit;
            }

            previous = digit;
        }

        Roman.reset();
        return number;
    }

    /**
     * checkLiteralCountValidity() method keeps the count of all repeatable and non repeatable Literals.
     */
    private static void count(Character literal) {
        if (Roman.nonRepeating.stream().filter(item -> item.equals(literal)).findFirst().isPresent()) {
            if (Roman.nonRepeatableCount.get(literal).equals(Roman.ZERO)) {
                Roman.nonRepeatableCount.put(literal, Roman.ONE);
            } else {
                System.err.println("Error : Roman Numeral V,L,D cannot be repeated.");
            }
        } else if (Roman.repeating.stream().filter(item -> item.equals(literal)).findFirst().isPresent()) {

            final Optional<Character> previous = Roman.repeatableCount.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(Roman.MAX)).map(entry -> entry.getKey()).findFirst();

            if (previous.isPresent()) {
                if (previous.get().equals(literal)) {
                    System.err.println("Error : Roman Numeral " + literal + " cannot repeat 4 times successively");
                } else if (Roman.getValue(literal.charValue()) > Roman.getValue(previous.get().charValue())) {
                    Roman.repeatableCount.put(literal,
                            Integer.valueOf(Roman.repeatableCount.get(literal).intValue() + 1));
                    Roman.repeatableCount.put(previous.get(), Roman.ZERO);
                }
            } else {
                Roman.repeatableCount.put(literal, Integer.valueOf(Roman.repeatableCount.get(literal).intValue() + 1));
            }
        }
    }

    @SuppressWarnings("boxing")
    private static final List<Character> nonRepeating = Arrays.asList('D', 'L', 'V');
    @SuppressWarnings("boxing")
    private static final List<Character> repeating = Arrays.asList('I', 'V', 'X', 'M');

    @SuppressWarnings({ "serial", "boxing" })
    private static Map<Character, Integer> repeatableCount = new HashMap<Character, Integer>() {
        {
            this.put('I', 0);
            this.put('X', 0);
            this.put('C', 0);
            this.put('M', 0);
        }
    };

    @SuppressWarnings({ "serial", "boxing" })
    private static Map<Character, Integer> nonRepeatableCount = new HashMap<Character, Integer>() {
        {
            this.put('V', 0);
            this.put('L', 0);
            this.put('D', 0);
        }
    };

    @SuppressWarnings({ "serial", "boxing" })
    private static Map<Integer, List<Integer>> SUBTRACTABLE = Collections
            .unmodifiableMap(new HashMap<Integer, List<Integer>>() {
                {
                    this.put(1, Arrays.asList(5, 10));
                    this.put(5, Collections.emptyList());
                    this.put(10, Arrays.asList(50, 100));
                    this.put(50, Collections.emptyList());
                    this.put(100, Arrays.asList(100, 1000));
                    this.put(500, Collections.emptyList());
                    this.put(1000, Collections.emptyList());
                }
            });

    @SuppressWarnings({ "serial", "boxing" })
    private static Map<Character, Integer> ROMAN_TO_NUMERIC = Collections
            .unmodifiableMap(new HashMap<Character, Integer>() {
                {
                    this.put('I', 1);
                    this.put('V', 5);
                    this.put('X', 10);
                    this.put('L', 50);
                    this.put('C', 100);
                    this.put('D', 500);
                    this.put('M', 1000);
                }
            });

    private static void reset() {
        Roman.repeatableCount.forEach((key, value) -> Roman.repeatableCount.merge(key, Roman.ZERO,
                (v1, v2) -> Roman.ZERO));
        Roman.nonRepeatableCount.forEach((key, value) -> Roman.nonRepeatableCount.merge(key, Roman.ZERO,
                (v1, v2) -> Roman.ZERO));
    }

    private static int getValue(final char number) {
        return Roman.ROMAN_TO_NUMERIC.get(Character.valueOf(number)).intValue();
    }

    private static boolean isSubtractable(int decimal, int lastNumber) {
        return Roman.SUBTRACTABLE.get(Integer.valueOf(decimal)).contains(Integer.valueOf(lastNumber));
    }
}
