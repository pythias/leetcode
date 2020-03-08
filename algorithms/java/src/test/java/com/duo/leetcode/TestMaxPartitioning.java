package com.duo.leetcode;

import com.duo.leetcode._1000._1043.MaxPartitioning;
import org.junit.Assert;
import org.junit.Test;

public class TestMaxPartitioning {
    @Test
    public void test0() {
        MaxPartitioning partitioning = new MaxPartitioning();
        Assert.assertEquals(17, partitioning.maxSumAfterPartitioning(new int[]{2, 3, 5, 1}, 3));
        Assert.assertEquals(27, partitioning.maxSumAfterPartitioning(new int[]{2, 3, 5, 1, 6}, 3));
        Assert.assertEquals(84, partitioning.maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
        Assert.assertEquals(71, partitioning.maxSumAfterPartitioning(new int[]{15, 10, 9, 1, 2, 5, 7}, 3));
        Assert.assertEquals(74, partitioning.maxSumAfterPartitioning(new int[]{5, 16, 3, 1, 4, 6, 7}, 3));
        Assert.assertEquals(76, partitioning.maxSumAfterPartitioning(new int[]{5, 16, 10, 1, 4, 6, 7}, 3));
        Assert.assertEquals(74, partitioning.maxSumAfterPartitioning(new int[]{5, 16, 8, 1, 4, 6, 7}, 3));
    }
}
