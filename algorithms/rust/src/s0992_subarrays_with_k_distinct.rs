//992. K 个不同整数的子数组
//https://leetcode-cn.com/problems/subarrays-with-k-different-integers/
//少读了连续的字眼："contiguous, not necessarily distinct"
impl Solution {
    //窗口解法
    pub fn subarrays_with_k_distinct(a: Vec<i32>, k: i32) -> i32 {
        
    }

    //最笨解法
    pub fn s1(a: Vec<i32>, k: i32) -> i32 {
        let len = a.len();
        let uk = k as usize;
        let mut count = 0;
        for i in 0..len {
            let mut sub = std::collections::HashMap::new();
            sub.insert(a[i], 0);
            if sub.len() == uk {
                count += 1;
            }

            for j in (i+1)..len {
                if !sub.contains_key(&a[j]) {
                    if sub.len() == uk {
                        break;
                    }
                    sub.insert(a[j], 0);
                }
                
                if sub.contains_key(&a[j]) && sub.len() == uk {
                    count += 1;
                }
            }
        }

        return count;
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
