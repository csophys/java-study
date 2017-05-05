package base.base;

import org.junit.Assert;

/**
 * Created by csophys on 17/4/23.
 */
public class Equal {

    public static void main(String[] args) {
        String str1="csophys";
        String str2="csophys";
        Assert.assertTrue(str1.equals(str2));

        String str3 = new String(" csophys");
        String str4 = new String("csophys");
        Assert.assertTrue(str3.equals(str4));

        StringBuilder csophys5 = new StringBuilder("csophys");
        StringBuilder csophys6 = new StringBuilder("csophys");
        Assert.assertNotEquals(csophys5,csophys6);

    }
}
