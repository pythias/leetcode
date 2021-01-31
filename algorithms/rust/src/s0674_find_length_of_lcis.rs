/**
 * 674. Longest Continuous Increasing Subsequence
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 */
impl Solution {
    pub fn find_length_of_lcis(nums: Vec<i32>) -> i32 {
        let l = nums.len();
        if nums.is_empty() || l > 10000 {
            return 0;
        }

        let mut c0 = 1;
        let mut c1 = 1;
        for i in 1..nums.len() {
            if nums[i] - nums[i-1] > 0 {
                c1 += 1;
            } else {
                c1 = 1;
            }

            if c1 > c0 {
                c0 = c1;
            }
        }

        return c0;
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_674() {
        assert_eq!(Solution::find_length_of_lcis(vec![1, 3, 5, 7, 4]), 4);
        assert_eq!(Solution::find_length_of_lcis(vec![1, 1, 1]), 1);
        assert_eq!(Solution::find_length_of_lcis(vec![2, 1]), 1);
        assert_eq!(Solution::find_length_of_lcis(vec![1, 2]), 2);
        assert_eq!(Solution::find_length_of_lcis(vec![1, 3, 5, 4, 7, 1, 2, 3, 4]), 4);
    }
}