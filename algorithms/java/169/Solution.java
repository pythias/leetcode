package duo.leetcode.p169;

import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int major = nums[0];
        for (int num : nums) {
            if (count == 0) {
                major = num;
                count = 1;
            } else if (major == num) {
                count++;
            } else {
                count--;
            }
        }

        return major;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[] {1, 2, 3, 2, 1, 2, 2}));
        System.out.println(solution.majorityElement(new int[] {1, 2, 2}));
        System.out.println(solution.majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
        System.out.println(solution.majorityElement(new int[] {2}));
    }
}