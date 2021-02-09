// 665. 非递减数列
// https://leetcode-cn.com/problems/non-decreasing-array/
impl Solution {
    pub fn check_possibility(nums: Vec<i32>) -> bool {
        let mut c = 0;
        for i in 1..nums.len() {
            if nums[i - 1] > nums[i] {
                c += 1;
                if c >= 2 {
                    return false;
                }

                if i > 1 && nums[i - 2] > nums[i] && (i < nums.len() - 1) && nums[i - 1] > nums[i + 1] {
                    return false;
                }
            }
        }

        return true;
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0665() {
        assert_eq!(Solution::check_possibility(vec![4,2,3]), true);
        assert_eq!(Solution::check_possibility(vec![4,2,1]), false);
        assert_eq!(Solution::check_possibility(vec![3,4,2,3]), false);
        assert_eq!(Solution::check_possibility(vec![3,4,4,3]), true);
        assert_eq!(Solution::check_possibility(vec![5,4,4,3]), false);
        assert_eq!(Solution::check_possibility(vec![3,4,3,3]), true);
        assert_eq!(Solution::check_possibility(vec![5,7,1,8]), true);
    }
}