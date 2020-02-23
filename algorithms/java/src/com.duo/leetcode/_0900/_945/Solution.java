package com.duo.leetcode._0900._945;

import java.util.Arrays;
import com.duo.leetcode.Algorithm;

public class Solution implements Algorithm {
    public int minIncrementForUnique(int[] A) {
        int steps = 0;
        int last = -1;
        int inc = 0;
        Arrays.sort(A);
        for (int a : A) {
            if (a <= last) {
                inc = last - a + 1;
                steps += inc;
                last = a + inc;
            } else {
                last = a;
            }
        }

        return steps;
    }

    public void run() {
        System.out.println(this.minIncrementForUnique(new int[] {1, 1, 1, 1}));
        System.out.println(this.minIncrementForUnique(new int[] {1, 2, 2}));
        System.out.println(this.minIncrementForUnique(new int[] {1, 1, 3, 3}));
        System.out.println(this.minIncrementForUnique(new int[] {1, 1, 2, 2}));
        System.out.println(this.minIncrementForUnique(new int[] {3, 2, 1, 2, 1, 7}));
        System.out.println(this.minIncrementForUnique(new int[] {1, 1, 4}));
        System.out.println(this.minIncrementForUnique(new int[] {1, 2, 4}));
    }
}