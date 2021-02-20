//https://leetcode.com/problems/max-consecutive-ones-iii/
impl Solution {
    pub fn longest_ones(a: Vec<i32>, k: i32) -> i32 {
        let mut count = 0;
        let mut max = 0;

        if k == 0 {
            for n in a {
                if n == 0 {
                    count = 0;
                    continue;
                }
                count += 1;
                max = std::cmp::max(count, max);
            }
            
            return max;
        }

        let mut rk = k;
        let mut i = 0;
        let mut last = 0;
        let length = a.len();
        while i < length {
            if a[i] == 0 {
                rk -= 1;
                if rk == (k - 1) {
                    if count == 0 {
                        last = i + 1;
                    } else {
                        last = i;
                    }
                } else if rk == -1 {
                    i = last;
                    rk = k;
                    count = 0;
                    last = 0;
                    continue;
                }
            }

            count += 1;
            max = std::cmp::max(count, max);
            i += 1;
        }

        return std::cmp::min(max + rk, a.len() as i32);
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_1004() {
        assert_eq!(Solution::longest_ones(vec![1,1,1,0], 0), 3);
        assert_eq!(Solution::longest_ones(vec![1,1,1,0,0,0,1,1,1,1,0], 2), 6);
        assert_eq!(Solution::longest_ones(vec![1,1,1,0], 2), 4);
        assert_eq!(Solution::longest_ones(vec![0,1,1,1,0], 2), 5);
        assert_eq!(Solution::longest_ones(vec![0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], 3), 10);
    }
}
