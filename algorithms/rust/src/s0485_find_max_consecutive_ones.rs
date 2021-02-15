//485. Max Consecutive Ones
//https://leetcode.com/problems/max-consecutive-ones/
impl Solution {
    pub fn find_max_consecutive_ones(nums: Vec<i32>) -> i32 {
        let mut c = 0;
        let mut max = 0;
        for n in nums {
            if n == 0 {
                c = 0;
                continue;
            }
            c += 1;
            max = std::cmp::max(c, max);
        }
        
        return max;
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0485() {
        assert_eq!(Solution::find_max_consecutive_ones(vec![1,1,1,0]), 3);
        assert_eq!(Solution::find_max_consecutive_ones(vec![1,1,1,0,1,1,1,1]), 4);
    }
}
