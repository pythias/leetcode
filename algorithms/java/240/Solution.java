package com.duo.leetcode;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int size = matrix[0].length - 1;
        int col = 0;
        for (int i = 0; i < matrix.length; i++) {
            while (col >= 0 && col <= size) {
                if (target == matrix[i][col]) {
                    return true;
                }

                if (i == 0) {
                    if (target > matrix[i][col]) {
                        if (col == size) {
                            break;
                        }
                        col++;
                    } else {
                        col--;
                        break;
                    }
                } else {
                    if (target > matrix[i][col]) {
                        break;
                    } else {
                        col--;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 5));
        System.out.println(solution.searchMatrix(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 18));
        System.out.println(solution.searchMatrix(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 19));
        System.out.println(solution.searchMatrix(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 25));
        System.out.println(solution.searchMatrix(new int[][] { { 1 }, { 3 }, { 5 } }, 5));
    }
}