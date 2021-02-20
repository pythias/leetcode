//992. K 个不同整数的子数组
//https://leetcode-cn.com/problems/subarrays-with-k-different-integers/
//1. 连续："contiguous, not necessarily distinct"
//2. 还有一个隐形的条件: "1 <= A[i] <= A.length"
impl Solution {
    //窗口解法
    pub fn subarrays_with_k_distinct(a: Vec<i32>, k: i32) -> i32 {
        return sub_k(&a, k as usize) - sub_k(&a, (k - 1) as usize);
    }
}

fn sub_k(a: &Vec<i32>, k: usize) -> i32 {
    if k == 0 {
        return 0;
    }

    let len = a.len();
    let mut count = 0;
    let mut sub = vec![0; len + 1];
    let mut left = 0;
    let mut all = 0;
    for right in 0..len {
        if sub[a[right] as usize] == 0 {
            count += 1;
        }
        sub[a[right] as usize] += 1;

        while (count > k) {
            sub[a[left] as usize] -= 1;
            if sub[a[left] as usize] == 0 {
                count -= 1;
            }
            left += 1;
            println!("LEFT, right:{:?} left:{:?}, sub:{:?}, count:{:?}", right, left, sub, count);
        }
        
        println!("ALL, right:{:?} left:{:?}, sub:{:?}, count:{:?}", right, left, sub, count);
        all += right - left + 1;
    }

    return all as i32;
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0992() {
        assert_eq!(Solution::subarrays_with_k_distinct(vec![1,1,1], 1), 6);
        assert_eq!(Solution::subarrays_with_k_distinct(vec![2,1,1,1,2], 1), 81);
        assert_eq!(Solution::subarrays_with_k_distinct(vec![1,2], 1), 2);
        assert_eq!(Solution::subarrays_with_k_distinct(vec![1,2,1,2,3], 2), 7);
        assert_eq!(Solution::subarrays_with_k_distinct(vec![1,2,1,3,4], 3), 3);
    }
}
