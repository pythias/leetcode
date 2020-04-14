package com.duo.leetcode._0100._169;

import com.duo.leetcode.Algorithm;

public class Solution implements Algorithm {
    public int majorityElement(int[] nums) {
        int count = 0;
        int major = nums[0];
        for (int num : nums) {
            if (count == 0) {
                major = num;
                count = 1;
            } else if (major == num) {
                count++;
            } else {
                count--;
            }
        }

        return major;
    }

    public void run() {
        System.out.println(this.majorityElement(new int[] {1, 2, 3, 2, 1, 2, 2}));
        System.out.println(this.majorityElement(new int[] {1, 2, 2}));
        System.out.println(this.majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
        System.out.println(this.majorityElement(new int[] {2}));
    }
}