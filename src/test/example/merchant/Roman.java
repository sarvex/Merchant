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
public class Roman {

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
     * Test method for {@link com.example.merchant.Roman#toDecimal(java.lang.String)}.
     */
    @Test
    @SuppressWarnings("static-method")
    public void testToDecimal() {
        final String roman = "MMXV";
        final int expected = 2015;

        final int actual = com.example.merchant.Roman.toDecimal(roman);

        Assert.assertEquals(expected, actual);
    }

}
