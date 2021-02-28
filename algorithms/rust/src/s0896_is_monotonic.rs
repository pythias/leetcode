impl Solution {
    pub fn is_monotonic(a: Vec<i32>) -> bool {
        let mut last = a[0];
        let mut seq = 0;
        for i in 1..a.len() {
            if a[i] == last {
                continue;
            }

            if a[i] > last {
                if seq == 0 {
                    seq = 1;
                } else if seq == 2 {
                    return false;
                }
            } else {
                if seq == 0 {
                    seq = 2;
                } else if seq == 1 {
                    return false;
                }
            }
            last = a[i];
        }
        true
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0896() {
        assert_eq!(Solution::is_monotonic(vec![1,1,2,3]), true);
        assert_eq!(Solution::is_monotonic(vec![3,3,2,1,1]), true);
        assert_eq!(Solution::is_monotonic(vec![1,2,1]), false);
        assert_eq!(Solution::is_monotonic(vec![1,1,1]), true);
    }
}
