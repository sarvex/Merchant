/**
 *
 */
package com.example.merchant;

/**
 * @author sarvex
 */
public class Runner {

    public static void main(String[] args) {

        String filePath = "./input";
        if (args.length != 0) {
            filePath = args[0];
        }

        Reader.read(filePath);
        Writer.answer();
    }
}
