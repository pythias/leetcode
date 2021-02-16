impl Solution {
    pub fn array_pair_sum(nums: Vec<i32>) -> i32 {
        let mut n1 = nums;
        n1.sort();
        return n1.chunks(2).fold(0, |sum, x| sum + x[0]);
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
