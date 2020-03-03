package com.duo.leetcode;

import com.duo.leetcode._0500._520.DetectCapital;
import org.junit.Assert;
import org.junit.Test;

public class TestDetectCapital {
    @Test
    public void test0() {
        DetectCapital detectCapital = new DetectCapital();
        Assert.assertEquals(true, detectCapital.detectCapitalUse("Leetcode"));
        Assert.assertEquals(true, detectCapital.detectCapitalUse("CHN"));
        Assert.assertEquals(false, detectCapital.detectCapitalUse("reLease"));
    }
}
