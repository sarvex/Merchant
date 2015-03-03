/**
 *
 */
package com.example.merchant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author sarvex
 */
public class Reader {

    private static final String CREDITS = "credits";
    private static final String IS = "is";
    private static final String QUESTION = "?";

    public static void read(String filePath) {

        final Path path = Paths.get(filePath);
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> Reader.process(line));
        } catch (final IOException exception) {
            exception.printStackTrace();
        }

        Store.getInstance().initialize(Processor::calculate);
    }

    public static void process(String line) {
        final List<String> tokens = Arrays.asList(line.split("((?<=:)|(?=:))|( )"));

        if (line.endsWith(Reader.QUESTION)) {
            Store.getInstance().addQuery(line);

        } else if (line.toLowerCase().endsWith(Reader.CREDITS)) {
            Store.getInstance().addSample(line);

        } else if ((tokens.size() == 3) && tokens.get(1).equalsIgnoreCase(Reader.IS)) {
            Store.getInstance().putRoman(tokens.get(0), tokens.get(tokens.size() - 1).charAt(0));

        }
    }
}
