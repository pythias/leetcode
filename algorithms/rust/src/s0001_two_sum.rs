/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 */
use std::collections::HashMap;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut c = HashMap::new();
        for (i, x) in nums.into_iter().enumerate() {
            match c.get(&(target - x)) {
                Some(j) => { return vec![*j as i32, i as i32]; },
                None => { c.insert(x, i); },
            }
        }

        vec![]
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0001() {
        assert_eq!(Solution::two_sum(vec![2, 7, 11, 5], 9), vec![0, 1]);
        assert_eq!(Solution::two_sum(vec![-2, -3, -4, -5], -8), vec![1, 3]);
        assert_eq!(Solution::two_sum(vec![0, 1, 2, 3, 0], 0), vec![0, 4]);
    }
}