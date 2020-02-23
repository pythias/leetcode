package com.duo.leetcode._0700._766;

import com.duo.leetcode.Algorithm;

public class Solution implements Algorithm {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void run() {
        System.out.println(this.isToeplitzMatrix(new int[][] {{1, 2, 3, 4}, {5, 1, 2, 3}, {7, 5, 1, 2}}));
        System.out.println(this.isToeplitzMatrix(new int[][] {{2, 2, 3, 4}, {5, 1, 2, 3}}));
        System.out.println(this.isToeplitzMatrix(new int[][] {{1}}));
        System.out.println(this.isToeplitzMatrix(new int[][] {{1, 2}}));
        System.out.println(this.isToeplitzMatrix(new int[][] {{1}, {2}}));
    }
}