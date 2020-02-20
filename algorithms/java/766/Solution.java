package duo.leetcode.p766;

class Solution {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isToeplitzMatrix(new int[][] {{1, 2, 3, 4}, {5, 1, 2, 3}, {7, 5, 1, 2}}));
        System.out.println(solution.isToeplitzMatrix(new int[][] {{2, 2, 3, 4}, {5, 1, 2, 3}}));
        System.out.println(solution.isToeplitzMatrix(new int[][] {{1}}));
        System.out.println(solution.isToeplitzMatrix(new int[][] {{1, 2}}));
        System.out.println(solution.isToeplitzMatrix(new int[][] {{1}, {2}}));
    }
}