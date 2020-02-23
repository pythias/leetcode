package duo.leetcode.p915;

class Solution {
    public int partitionDisjoint(int[] A) {
        int leftMax = A[0];
        int rightMax = -1;
        int disjoint = 1;

        for (int i = 1; i < A.length; i++) {
            if (leftMax > A[i]) {
                disjoint = i + 1;
                if (rightMax > leftMax) {
                    leftMax = rightMax;
                }
            } else {
                if (rightMax < A[i]) {
                    rightMax = A[i];
                }
            }
        }

        return disjoint;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partitionDisjoint(new int[] {5, 0, 3, 8, 6}));
        System.out.println(solution.partitionDisjoint(new int[] {1, 1, 1, 0, 6, 12}));
        System.out.println(solution.partitionDisjoint(new int[] {1, 1, 1, 2}));
        System.out.println(solution.partitionDisjoint(new int[] {4, 3, 1, 0, 3, 5}));
        System.out.println(solution.partitionDisjoint(new int[] {24, 11, 49, 80, 63, 8, 61, 22, 73, 85}));
        System.out.println(solution.partitionDisjoint(new int[] {32, 57, 24, 19, 0, 24, 49, 67, 87, 87}));
    }
}