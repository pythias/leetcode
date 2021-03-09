impl Solution {
    pub fn remove_duplicates(s: String) -> String {
        let mut bytes = s.into_bytes();
        let mut after: Vec<u8> = Vec::new();
        let mut last: u8 = 0;
        for byte in bytes {
            if byte == last {
                after.pop();
                last = match after.last() {
                    Some(v) => *v,
                    None => 0,
                }
            } else {
                last = byte;
                after.push(byte);
            }
        }

        let s = match std::str::from_utf8(after.as_ref()) {
            Ok(v) => v,
            Err(e) => panic!("Invalid UTF-8 sequence: {}", e),
        };

        String::from(s)
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0132() {
        assert_eq!(Solution::remove_duplicates(String::from("abbaca")), String::from("ca"));
        assert_eq!(Solution::remove_duplicates(String::from("acabbaca")), String::from(""));
        assert_eq!(Solution::remove_duplicates(String::from("abbaca")), String::from("ca"));
    }
}