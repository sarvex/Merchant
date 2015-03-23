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
public class Reader {

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
     * Test method for {@link com.example.merchant.Reader#process(java.lang.String)}.
     */
    @Test
    @SuppressWarnings("static-method")
    public void testRead() {
        final int expected = 5;

        com.example.merchant.Reader.read("./input");
        final int actual = com.example.merchant.Store.getInstance().getQueries().size();

        Assert.assertEquals(expected, actual);
    }
}
