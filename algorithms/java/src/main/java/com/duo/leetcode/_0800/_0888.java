package com.duo.leetcode._0800;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * 888. Fair Candy Swap
 * https://leetcode.com/problems/fair-candy-swap/
 */
public class _0888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int leftSum = this._sum(A);
        int rightSum = this._sum(B);
        int half = (leftSum + rightSum) / 2;
        List<Integer> diffs = new ArrayList<Integer>();
        for (int i : A) {
            diffs.add((half - leftSum) + i);
        }

        for (int i : B) {
            if (diffs.contains(i)) {
                return new int[] {i - (half - leftSum), i};
            }
        }

        return new int[] {0, 0};
    }

    private int _sum(int[] array) {
        return Arrays.stream(array).sum();
    }
}
