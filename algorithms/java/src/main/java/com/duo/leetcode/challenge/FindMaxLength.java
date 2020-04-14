package com.duo.leetcode.challenge;

import java.util.Arrays;

import com.duo.leetcode.Algorithm;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with
 * equal number of 0 and 1.
 * 
 * 没读懂题目
 */
public class FindMaxLength implements Algorithm {
    public int findMaxLength(int[] nums) {
        return 0;
    }

    private void _run(int[] stones) {
        System.out.printf("Contiguous Array of [%s] is %d\n",
                String.join(",", Arrays.stream(stones).mapToObj(String::valueOf).toArray(String[]::new)),
                this.findMaxLength(stones));
    }

    @Override
    public void run() {
        this._run(new int[] { 3, 7, 8 });
    }
}