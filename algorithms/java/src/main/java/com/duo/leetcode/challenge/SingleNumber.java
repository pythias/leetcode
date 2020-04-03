package com.duo.leetcode.challenge;

import com.duo.leetcode.Algorithm;

import java.util.HashMap;

public class SingleNumber implements Algorithm {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Boolean> single = new HashMap<>();
        for (int num : nums) {
            if (single.containsKey(num)) {
                single.remove(num);
                continue;
            }

            single.put(num, true);
        }

        for (int n : single.keySet()) {
            return n;
        }

        return 0;
    }

    @Override
    public void run() {
        System.out.println(this.singleNumber(new int[] { 2, 1, 2 }));
        System.out.println(this.singleNumber(new int[] { 1, 4, 4, 1, 2 }));
    }
}
