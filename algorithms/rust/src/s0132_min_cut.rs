use std::collections::HashMap;

impl Solution {
    pub fn min_cut(s: String) -> i32 {
        Self::get_min_cut(s.as_bytes()) - 1
    }

    fn get_min_cut(bytes: &[u8]) -> i32 {
        let len = bytes.len();
        if len < 2 {
            return len as i32;
        }

        let mut min = len as i32;
        for i in 0..len {
            for j in (i+1)..len {
                if bytes[j] != bytes[i] {
                    continue;
                }

                if !Self::is_palindrome(&bytes[i..=j]) {
                    continue;
                }

                let mut left = 0;
                let mut right = 0;
                if i > 0 {
                    left = Self::get_min_cut(&bytes[0..i]);
                }

                if j < (len - 1) {
                    right = Self::get_min_cut(&bytes[(j+1)..len]);
                }

                if left == 0 && right == 0 {
                    return 1;
                } else {
                    min = std::cmp::min(min, left + 1 + right);
                }
            }
        }

        min
    }

    fn is_palindrome(bytes: &[u8]) -> bool {
        let length = bytes.len();
        if length == 1 {
            return true;
        }

        for i in 0..(length / 2) {
            if bytes[i] != bytes[length - i - 1] {
                return false;
            }
        }

        true
    }
}



pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0132() {
        assert_eq!(Solution::min_cut(String::from("ab")), 1);
        assert_eq!(Solution::min_cut(String::from("aab")), 1);
        assert_eq!(Solution::min_cut(String::from("abadadeda")), 2);
        assert_eq!(Solution::min_cut(String::from("aba")), 0);
        assert_eq!(Solution::min_cut(String::from("aa")), 0);
        assert_eq!(Solution::min_cut(String::from("a")), 0);
    }
}