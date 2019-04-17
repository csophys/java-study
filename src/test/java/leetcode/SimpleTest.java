package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {
    static Simple simple=new Simple();

    @Test
    public void twoSum() {
        int[] twoSum = simple.twoSum(new int[]{2, 4, 5, 1}, 7);
        Assert.assertEquals(twoSum[0]+twoSum[1],7);
        twoSum = simple.twoSum(new int[]{2, 6, 5, 1}, 7);
        Assert.assertEquals(twoSum[0]+twoSum[1],7);
        twoSum = simple.twoSum(new int[]{2, 4, 3, 1}, 7);
        Assert.assertEquals(twoSum[0]+twoSum[1],7);
    }
}