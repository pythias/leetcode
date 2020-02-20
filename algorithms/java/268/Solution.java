package duo.leetcode.p268;

class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        return len * (1 + len) / 2 - sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println(solution.missingNumber(new int[] {3, 0, 1}));
    }
}