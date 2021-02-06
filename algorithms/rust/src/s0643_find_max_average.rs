impl Solution {
    pub fn find_max_average(nums: Vec<i32>, k: i32) -> f64 {
        let length = nums.len();
        let uk = k as usize;
        let mut current = 0;
        for i in 0..uk {
            current += nums[i];
        }
        
        let mut max = current;
        for i in uk..length {
            current += nums[i] - nums[i - uk];
            max = std::cmp::max(max, current);
        }
        
        return max as f64 / k as f64;
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0643() {
        assert_eq!(Solution::find_max_average(vec![1,12,-5,-6,50,3], 4), 12.75);
    }
}