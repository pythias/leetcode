//992. K 个不同整数的子数组
//https://leetcode-cn.com/problems/subarrays-with-k-different-integers/
//1. 连续："contiguous, not necessarily distinct"
//2. 还有一个隐形的条件: "1 <= A[i] <= A.length"
impl Solution {
    //窗口解法
    pub fn subarrays_with_k_distinct(a: Vec<i32>, k: i32) -> i32 {
        let len = a.len();
        let uk = k as usize;
        let mut all = 0;
        for i in 0..len {
            let mut left = 0;
            let mut right = 0;
            let mut count = 0;
            let mut sub = vec![0; len];
            if sub[a[i]] == 0 {
                count += 1;
            }
            sub[a[i]] += 1;

            for j in (i+1)..len {
                if sub[a[j]] == 0 {
                    count += 1;
                }
                sub[a[j]] += 1;

                if sub.contains(a[j]) {
                    if sub.len() == uk {
                        right = count;
                        break;
                    }

                    if sub.len() == (uk - 1) && left == 0 {
                        left = count;
                    }

                    sub[a[j]] += 1;
                }
                
                if sub.contains(&a[j]) && sub.len() == uk {
                    count += 1;
                }
            }

            all += right - left;
        }

        return all;
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0992() {
        assert_eq!(Solution::subarrays_with_k_distinct(vec![2,1,1,1,2], 1), 8);
        assert_eq!(Solution::subarrays_with_k_distinct(vec![1,1,1], 1), 6);
        assert_eq!(Solution::subarrays_with_k_distinct(vec![1,2], 1), 2);
        assert_eq!(Solution::subarrays_with_k_distinct(vec![1,2,1,2,3], 2), 7);
        assert_eq!(Solution::subarrays_with_k_distinct(vec![1,2,1,3,4], 3), 3);
    }
}
