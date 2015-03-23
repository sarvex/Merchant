/**
 *
 */
package com.example.merchant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author sarvex
 */
public class Store {

    List<String> samples = new ArrayList<>();
    List<String> queries = new ArrayList<>();

    Map<String, Character> symbols = new HashMap<>();
    Map<String, Double> rates = new HashMap<>();

    public void initialize(final Consumer<String> function) {
        this.samples.stream().forEach(query -> function.accept(query));
    }

    public void putRoman(String symbol, char value) {
        this.symbols.put(symbol, Character.valueOf(value));
    }

    public char getRoman(String symbol) {
        return this.symbols.get(symbol).charValue();
    }

    public double getRate(String element) {
        return this.rates.get(element).doubleValue();
    }

    public void putRate(String element, double value) {
        this.rates.put(element, Double.valueOf(value));
    }

    public void addQuery(String line) {
        this.queries.add(line);
    }

    public List<String> getQueries() {
        return this.queries;
    }

    public void addSample(String value) {
        this.samples.add(value);
    }

    public static Store getInstance() {
        return Store.instance;
    }

    private static Store instance = new Store();

}
