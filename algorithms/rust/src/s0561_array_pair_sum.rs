impl Solution {
    pub fn array_pair_sum(nums: Vec<i32>) -> i32 {
        let mut sum = 0;
        let mut n1 = nums;
        n1.sort();
        
        for i in (0..n1.len()).step_by(2) {
            sum += n1[i];
        }
        
        return sum;
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0561() {
        assert_eq!(Solution::array_pair_sum(vec![1,4,3,2]), 4);
        assert_eq!(Solution::array_pair_sum(vec![6,2,6,5,1,2]), 9);
    }
}
