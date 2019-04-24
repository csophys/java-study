package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {
    static Simple simple=new Simple();

    @Test
    public void twoSum() {
        int[] nums = new int[]{2, 4, 5, 1};
        int[] twoSum = simple.twoSum(nums, 7);
        Assert.assertEquals(nums[twoSum[0]]+nums[twoSum[1]],7);
        nums = new int[]{2, 6, 5, 1};
        twoSum = simple.twoSum(nums, 7);
        Assert.assertEquals(nums[twoSum[0]]+nums[twoSum[1]],7);
        nums = new int[]{2,5,5,11};
        twoSum = simple.twoSumHash(nums, 10);
        Assert.assertEquals(nums[twoSum[0]]+nums[twoSum[1]],10);
        Assert.assertNotEquals(twoSum[0],twoSum[1]);
    }
}