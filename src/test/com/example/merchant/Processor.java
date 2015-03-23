/**
 *
 */
package test.example.merchant;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author sarvex
 */
public class Processor {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        // Setup
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        // Tear Down
    }

    /**
     * Test method for {@link com.example.merchant.Processor#calculate(java.lang.String)}.
     */
    @Test
    @SuppressWarnings("static-method")
    public void testCalculate() {
        final double expected = 17.0;

        com.example.merchant.Reader.read("./input");
        final double actual = com.example.merchant.Store.getInstance().getRate("Silver");

        Assert.assertEquals(expected, actual, 0.0);
    }

//    /**
//     * Test method for {@link com.example.merchant.Processor#split(java.lang.String)}.
//     */
//    @Test
//    @SuppressWarnings("static-method")
//    public void testSplit() {
//        final List<String> expected = Arrays.asList("how", "many", "Credits", "is", "glob", "prok", "Iron", "?");
//
//        final List<String> actual = com.example.merchant.Processor(expected.stream().collect(Collectors.joining(" ")));
//
//        Assert.assert(actual.equals(expected));
//    }

}
