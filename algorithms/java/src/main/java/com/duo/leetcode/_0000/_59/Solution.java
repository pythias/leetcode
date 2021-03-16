package com.duo.leetcode._0000._59;

import com.duo.leetcode.Algorithm;

import java.util.Arrays;

public class Solution implements Algorithm {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int x = 0;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        while (x < n * n) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = ++x;
            }

            for (int i = top + 1; i <= bottom; i++) {
                matrix[i][right] = ++x;
            }

            for (int i = right - 1; i >= left; i--) {
                matrix[bottom][i] = ++x;
            }

            for (int i = bottom - 1; i > top; i--) {
                matrix[i][left] = ++x;
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return matrix;
    }

    @Override
    public void run() {
        System.out.println(Arrays.deepToString(this.generateMatrix(1)));
        System.out.println(Arrays.deepToString(this.generateMatrix(2)));
        System.out.println(Arrays.deepToString(this.generateMatrix(3)));
    }
}