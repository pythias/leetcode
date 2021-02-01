package com.duo.leetcode._0800;

import java.util.*;

/**
 * 888. Fair Candy Swap
 * https://leetcode.com/problems/fair-candy-swap/
 */
public class _0888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        return this._solution2(A, B);
    }

    private int[] _solution0(int[] A, int[] B) {
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

    private int[] _solution1(int[] A, int[] B) {
        int leftSum = this._sum(A);
        int rightSum = this._sum(B);
        int half = (leftSum + rightSum) / 2;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            int left = half - leftSum + A[i];
            for (int j = B.length - 1; j > -1; j--) {
                int right = B[j];
                if (right == left) {
                    return new int[] {A[i], right}; 
                }

                if (right < left) {
                    break;
                }
            }
        }


        return new int[] {0, 0};
    }

    private int[] _solution2(int[] A, int[] B) {
        int leftSum = this._sum(A);
        int rightSum = this._sum(B);
        int delta = (rightSum - leftSum) / 2;
        Set<Integer> diffs = new HashSet<Integer>();
        for (int i : A) {
            diffs.add(i);
        }

        for (int i : B) {
            if (diffs.contains(i - delta)) {
                return new int[] {i - delta, i};
            }
        }

        return new int[] {0, 0};
    }

    private int _sum(int[] array) {
        int s = 0;
        for (int i : array) {
            s += i;
        }
        return s;
    }
}
