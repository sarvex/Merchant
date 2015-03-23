package test.example.merchant;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Store {
    private static final List <String> queries =
            Arrays.asList("how much is pish tegj glob glob ?",
                    "how many Credits is glob prok Silver ?",
                    "how many Credits is glob prok Gold ?",
                    "how many Credits is glob prok Iron ?");

    @Before
    public void setUp() throws Exception {
        // SetUp code
    }

    @After
    public void tearDown() throws Exception {
        // tearDown code
    }

    @Test
    @SuppressWarnings("static-method")
    public void testGetInstance() {
        Assert.assertNotNull(com.example.merchant.Store.getInstance());
    }

    @Test
    @SuppressWarnings("static-method")
    public void testPutSymbol() {
        final String symbol = "sarvex";
        final char value = 'M';

        com.example.merchant.Store.getInstance().putRoman(symbol, value);
        final char result = com.example.merchant.Store.getInstance().getRoman(symbol);

        Assert.assertEquals(value, result);
    }

    @Test
    @SuppressWarnings("static-method")
    public void testGetRoman() {
        final String symbol = "jatasra";
        final char value = 'L';

        com.example.merchant.Store.getInstance().putRoman(symbol, value);
        final char result = com.example.merchant.Store.getInstance().getRoman(symbol);

        Assert.assertEquals(value, result);
    }

    @Test
    @SuppressWarnings("static-method")
    public void testGetRate() {
        final String element = "Gold";
        final double expected = 4567890123.91234567;

        com.example.merchant.Store.getInstance().putRate(element, expected);
        final double actual = com.example.merchant.Store.getInstance().getRate(element);

        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    @SuppressWarnings("static-method")
    public void testPutRate() {
        final String element = "Dirt";
        final double expected = .901234567890123456789012345678;

        com.example.merchant.Store.getInstance().putRate(element, expected);
        final double actual = com.example.merchant.Store.getInstance().getRate(element);

        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    @SuppressWarnings("static-method")
    public void testPutQuery() {
        final int expected = Store.queries.size();

        Store.queries.forEach(query -> com.example.merchant.Store.getInstance().addQuery(query));
        final int actual = com.example.merchant.Store.getInstance().getQueries().size();

        Assert.assertEquals(expected, actual);

    }

    @Test
    @SuppressWarnings("static-method")
    public void testGetQueries() {
        final int expected = Store.queries.size();

        final int actual = com.example.merchant.Store.getInstance().getQueries().size();

        Assert.assertEquals(expected, actual);
    }
}
