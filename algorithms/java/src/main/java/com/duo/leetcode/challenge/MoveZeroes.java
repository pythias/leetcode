package com.duo.leetcode.challenge;

import com.duo.leetcode.Algorithm;

import java.util.Arrays;

public class MoveZeroes implements Algorithm {
    public void moveZeroes(int[] nums) {
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                s++;
            } else if (s > 0) {
                nums[i - s] = nums[i];
            }
        }

        for (int i = 0; i < s; i++) {
            nums[nums.length - i - 1] = 0;
        }
    }

    @Override
    public void run() {
        int[] nums = new int[] { 1, 0, 0, 2, 3, 4, 0, 5, 6 };
        this.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
