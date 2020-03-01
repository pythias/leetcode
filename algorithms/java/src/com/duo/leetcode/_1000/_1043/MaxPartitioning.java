package com.duo.leetcode._1000._1043;

/**
 * 中文的题目和说明好像有问题
 * Input: A = [1,15,7,9,2,5,10], K = 3
 * Output: 84
 * Explanation: A becomes [15,15,15,9,10,10,10]
 * 比如如果分成 [15, 15, 15, 15, 15, 5, 10]，结果是 90
 * 所以应该是最大的子集合长度为K，不能超过K
 *
 */
public class MaxPartitioning {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int[] sums = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int max = 0;
            for (int j = 1; j <= K && (i - j + 1) >= 0; j++) {
                max = Math.max(max, A[i - j + 1]);
                sums[i] = Math.max(sums[i], ((i - j < 0) ? 0 : sums[i - j])  + max * j);
            }
        }
        return sums[A.length - 1];
    }
}
