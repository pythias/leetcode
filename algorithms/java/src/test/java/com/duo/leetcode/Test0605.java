package com.duo.leetcode;

import com.duo.leetcode._0600._0605;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Test0605 {
    @Test
    public void test0() {
        this._test(new int[] {0}, 1, true);
        this._test(new int[] {0, 0, 1, 0, 1}, 1, true);
        this._test(new int[] {1, 0, 0, 0, 0, 1}, 1, true);
        this._test(new int[] {1, 0, 0, 0, 0, 1}, 2, false);
        this._test(new int[] {1, 0, 0, 0, 0}, 2, true);
    }

    private void _test(int[] v, int c, boolean e) {
        _0605 solution = new _0605();
        boolean a = solution.canPlaceFlowers(v, c);
        System.out.printf("Places: %s, flowers: %d, expected: %s, actual: %s\n", Arrays.toString(v), c, e, a);
        Assert.assertEquals(e, a);
    }
}
