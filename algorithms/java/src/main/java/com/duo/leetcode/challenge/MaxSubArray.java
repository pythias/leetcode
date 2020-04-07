package com.duo.leetcode.challenge;

import com.duo.leetcode.Algorithm;

public class MaxSubArray implements Algorithm {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int i = 0;
        while (i < nums.length) {
            if (sum > 0 && sum + nums[i] > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }

            max = Math.max(max, sum);
            i++;
        }

        return max;
    }

    @Override
    public void run() {
        System.out.println(this.maxSubArray(new int[] { -2 }));
        System.out.println(this.maxSubArray(new int[] { -2, -1 }));
        System.out.println(this.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
        System.out.println(this.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4, 2 }));
    }
}
