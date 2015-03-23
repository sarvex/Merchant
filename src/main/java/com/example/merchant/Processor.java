/**
 *
 */
package com.example.merchant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sarvex
 */
public class Processor {

    private static final String TOKEN = "((?<=:)|(?=:))|( )";
    private static final String QUESTION = "?";
    private static final String IS = "is";
    private static final String CREDITS = "credits";

    static void calculate(String query) {
        final List<String> tokens = Arrays.asList(query.split(Processor.TOKEN));
        int split = 0;
        int credit = 0;
        String comodity = null;
        List<String> value = null;

        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).toLowerCase().equals(Processor.CREDITS)) {
                credit = Integer.parseInt(tokens.get(i - 1));
            }
            if (tokens.get(i).toLowerCase().equals(Processor.IS)) {
                split = i - 1;
                comodity = tokens.get(i - 1);
            }

            value = tokens.subList(0, split);
        }

        if (null != value) {

            final StringBuilder roman = new StringBuilder();
            for (final String element : value) {
                roman.append(Store.getInstance().getRoman(element));
            }

            Store.getInstance().putRate(comodity, credit / Roman.toDecimal(roman.toString()));
        }
    }

    public static int value(List<String> symbols) {

        final StringBuilder roman = new StringBuilder();

        for (final String symbol : symbols) {
            roman.append(Store.getInstance().getRoman(symbol));
        }

        return Roman.toDecimal(roman.toString());
    }

    public static List<String> split(String query) {
        final List<String> result = new ArrayList<>(Arrays.asList(query.split(Processor.TOKEN)));
        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).toLowerCase().equals(Processor.IS)) {
                startIndex = i + 1;
            } else if (result.get(i).toLowerCase().equals(Processor.QUESTION)) {
                endIndex = i;
            }
        }

        return result.subList(startIndex, endIndex);
    }
}
