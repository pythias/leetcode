/**
 * 796. Rotate String
 * https://leetcode.com/problems/rotate-string/
 */
impl Solution {
    pub fn rotate_string(a: String, b: String) -> bool {
        if a.is_empty() {
            return b.is_empty();
        }

        if a.len() > 1000 || a.len() != b.len() {
            return false;
        }

        let mut i = 0;

        loop {
            let f = a[i..].find(&b[0..1]);
            if f.is_none() {
                return false;
            }

            let j = f.unwrap() as usize;
            let mut c = String::from(&a[i+j..]);
            c.push_str(&a[..i+j]);
            if b.eq(&c) {
                return true;
            }

            i += j + 1;
        }
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_796() {
        assert_eq!(Solution::rotate_string(String::from("abcdce"), String::from("cdceab")), true);
        assert_eq!(Solution::rotate_string(String::from("abcdce"), String::from("ceabcd")), true);
        assert_eq!(Solution::rotate_string(String::from("abcde"), String::from("abced")), false);
        assert_eq!(Solution::rotate_string(String::from("abcdce"), String::from("cdceba")), false);
    }
}