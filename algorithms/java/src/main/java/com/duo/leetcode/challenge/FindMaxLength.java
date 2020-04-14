package com.duo.leetcode.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.duo.leetcode.Algorithm;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with
 * equal number of 0 and 1.
 */
public class FindMaxLength implements Algorithm {
    public int findMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> pos = new HashMap<>();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num == 0 ? -1 : 1;
            if (sum == 0) {
                max = i + 1;
            } else if (pos.containsKey(sum)) {
                max = Math.max(max, i - pos.get(sum));
            } else {
                pos.put(sum, i);
            }
        }

        return max;
    }

    private void _run(int[] stones) {
        System.out.printf("Contiguous Array of [%s] is %d\n",
                String.join(",", Arrays.stream(stones).mapToObj(String::valueOf).toArray(String[]::new)),
                this.findMaxLength(stones));
    }

    @Override
    public void run() {
        this._run(new int[] { 0, 1, 0, 1, 0 });
        this._run(new int[] { 0, 1, 0 });
        this._run(new int[] { 0, 1 });
        this._run(new int[] { 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1 });
        this._run(new int[] { 0, 1, 0, 0, 0, 1 });
    }
}