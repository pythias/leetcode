package com.duo.leetcode;

import com.duo.leetcode._0800._821.ShortestToChar;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestShortestToChar {
    @Test
    public void test0() {
        this.test(new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}, "loveleetcode", 'e');
    }

    @Test
    public void test1() {
        this.test(new int[]{1, 0, 1, 1, 0, 1, 2}, "console", 'o');
    }

    private void test(int[] e, String S, char c) {
        ShortestToChar shortest = new ShortestToChar();
        int[] a = shortest.shortestToChar(S, c);
        System.out.printf("Expected: %s\nActual:   %s\n", Arrays.toString(e), Arrays.toString(a));
        Assert.assertArrayEquals(e, a);
    }
}
