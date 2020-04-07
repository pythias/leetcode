package com.duo.leetcode.challenge;

import com.duo.leetcode.Algorithm;

import java.util.HashMap;
import java.util.Map;

public class CountElements implements Algorithm {
    public int countElements(int[] arr) {
        Map<Integer, Integer> plus = new HashMap<>();
        for (int a : arr) {
            plus.put(a, 1);
        }

        int count = 0;
        for (int a : arr) {
            if (plus.containsKey(a + 1)) {
                count++;
            }
        }

        return count;
    }

    @Override
    public void run() {
        System.out.println(this.countElements(new int[] { 1, 3, 2, 3, 5, 0}));
        System.out.println(this.countElements(new int[] { 1, 2, 3}));
        System.out.println(this.countElements(new int[] { 1, 1, 2}));
        System.out.println(this.countElements(new int[] { 1, 1, 2, 2}));
    }
}
