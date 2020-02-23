package com.duo.leetcode._0400._448;

import com.duo.leetcode.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Solution implements Algorithm {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] all = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            all[i] = i + 1;
        }

        for (Integer i : nums) {
            all[i - 1] = 0;
        }
        
        List<Integer> missing = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (all[i] > 0) {
                missing.add(all[i]);
            }
        }
        return missing;
    }

    public void run() {
        System.out.println(this.findDisappearedNumbers(new int[] {1, 2, 3, 1, 5}));
        System.out.println(this.findDisappearedNumbers(new int[] {2, 3, 3, 5, 2, 3, 1, 8}));
    }
}