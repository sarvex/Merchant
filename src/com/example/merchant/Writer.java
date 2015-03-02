/**
 *
 */
package com.example.merchant;

import java.util.List;

/**
 * @author sarvex
 */
public class Writer {

    private static final String SPACE = " ";
    private static final String CREDITS = "Credits";
    private static final String HOW_MANY = "how many credits is";
    private static final String HOW_MUCH = "how much is";
    private static final String NO_IDEA = "I have no idea what you are talking about!";

    public static void answer() {
        for (final String query : Store.getInstance().getQueries()) {

            final StringBuilder output = new StringBuilder(query).append(Writer.SPACE);

            try {
                if (query.toLowerCase().startsWith(Writer.HOW_MUCH)) {

                    final int value = Processor.value(Processor.split(query));
                    output.append(Double.toString(value));

                } else if (query.toLowerCase().startsWith(Writer.HOW_MANY)) {
                    final List<String> symbols = Processor.split(query);
                    final double value = Store.getInstance().getRate(symbols.remove(symbols.size() - 1))
                            * Processor.value(symbols);

                    output.append(Double.toString(value)).append(Writer.SPACE).append(Writer.CREDITS);
                } else {
                    output.append(Writer.NO_IDEA);
                }
            } catch (final Exception exception) {
                output.append(Writer.NO_IDEA + exception);
            }

            System.out.println(output);
        }
    }
}
