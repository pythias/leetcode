package com.duo.leetcode;

import com.duo.leetcode._0900._915.PartitionDisjoint;
import org.junit.Assert;
import org.junit.Test;

public class TestPartitionDisjoint {
    @Test
    public void testPartitionDisjoint() {
        PartitionDisjoint s = new PartitionDisjoint();
        Assert.assertEquals(3, s.partitionDisjoint(new int[] {5, 0, 3, 8, 6}));
        Assert.assertEquals(4, s.partitionDisjoint(new int[] {1, 1, 1, 0, 6, 12}));
        Assert.assertEquals(1, s.partitionDisjoint(new int[] {1, 1, 1, 2}));
        Assert.assertEquals(5, s.partitionDisjoint(new int[] {4, 3, 1, 0, 3, 5}));
        Assert.assertEquals(9, s.partitionDisjoint(new int[] {24, 11, 49, 80, 63, 8, 61, 22, 73, 85}));
        Assert.assertEquals(7, s.partitionDisjoint(new int[] {32, 57, 24, 19, 0, 24, 49, 67, 87, 87}));
    }

}
