import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] all = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            all[i] = i + 1;
        }

        for (Integer i : nums) {
            all[i - 1] = 0;
        }
        
        List<Integer> missing = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (all[i] > 0) {
                missing.add(all[i]);
            }
        }
        return missing;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findDisappearedNumbers(new int[] {1, 2, 3, 1, 5}));
        System.out.println(solution.findDisappearedNumbers(new int[] {2, 3, 3, 5, 2, 3, 1, 8}));
    }
}