package com.duo.leetcode._0200._268;

import com.duo.leetcode.Algorithm;

public class Solution implements Algorithm {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        return len * (1 + len) / 2 - sum;
    }

    public void run() {
        System.out.println(this.missingNumber(new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println(this.missingNumber(new int[] {3, 0, 1}));
    }
}