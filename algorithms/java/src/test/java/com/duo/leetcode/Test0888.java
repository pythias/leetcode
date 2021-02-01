package com.duo.leetcode;

import com.duo.leetcode._0800._0888;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Test0888 {
    @Test
    public void test0() {
        this._test(new int[] {1, 3}, new int[] {1, 2, 3}, new int[] {1, 2});
    }

    private void _test(int[] A, int[] B, int[] E) {
        _0888 solution = new _0888();
        int[] R = solution.fairCandySwap(A, B);
        System.out.printf("Candies: %s, candies: %s, expect: %s, actual: %s\n", Arrays.toString(A), Arrays.toString(B), Arrays.toString(E), Arrays.toString(R));
        Assert.assertTrue(Arrays.equals(E, R));
    }
}
