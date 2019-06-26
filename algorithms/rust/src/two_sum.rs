

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        for (i, x) in nums.into_iter().enumerate() {
            for j in (i+1)..nums.len() {
                if nums.get(j) == Some(&(target - x)) {
                    return vec![i as i32, j as i32];
                }
            }
        }

        vec![]
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn two_sum() {
        assert_eq!(Solution::two_sum(vec![2, 7, 11, 5], 9), vec![0, 1]);
        assert_eq!(Solution::two_sum(vec![-2, -3, -4, -5], -8), vec![1, 3]);
        assert_eq!(Solution::two_sum(vec![0, 1, 2, 3, 0], 0), vec![0, 4]);
    }
}