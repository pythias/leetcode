impl Solution {
    pub fn partition(s: String) -> Vec<Vec<String>> {
        vec![]
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
    fn test_0131() {
        assert_eq!(Solution::partition(String::from("ab")), vec![vec![String::from("a"), String::from("b")]]);
        assert_eq!(Solution::partition(String::from("aab")), vec![vec![String::from("a"), String::from("a"), String::from("b")], vec![String::from("aa"), String::from("b")]]);
    }
}