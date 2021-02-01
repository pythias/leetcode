/**
 * 575. Distribute Candies
 * https://leetcode.com/problems/distribute-candies/
 */
impl Solution {
    pub fn distribute_candies(candies: i32, num_people: i32) -> Vec<i32> {
        if num_people < 1 {
            return vec![]
        }

        let num: usize = num_people as usize;
        let mut value = vec![0; num];
        if candies == 0 {
            return value;
        }

        let mut remain: i32 = candies;
        let mut count = 1;
        let mut index: usize = 0;
        loop {
            if index >= num {
                index = 0;
            }

            if count >= remain {
                value[index] += remain;
                return value;
            }

            value[index] += count;
            remain -= count;
            index += 1;
            count += 1;
        }
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test_0575() {
        assert_eq!(Solution::distribute_candies(7, 3), vec![2, 2, 3]);
        assert_eq!(Solution::distribute_candies(10, 3), vec![5, 2, 3]);
        assert_eq!(Solution::distribute_candies(11, 3), vec![5, 3, 3]);
        assert_eq!(Solution::distribute_candies(3, 4), vec![1, 2, 0, 0]);
    }
}