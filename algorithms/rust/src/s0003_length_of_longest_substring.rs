impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        let length = s.len();
        if length == 0 {
            return 0;
        }

        let mut indexes = Vec::new();
        for i in 0..128 {
            indexes.push(-1);
        }

        let bytes = s.as_bytes();
        let mut max = 1;
        let mut prev = 0;
        let mut i = 0;
        for b in bytes {
            let b1 = *b as usize;
            let index = indexes[b1];
            if index >= prev {
                max = std::cmp::max(max, i - prev);
                prev = index + 1;
            }

            indexes[b1] = i;
            i += 1;
        }

        max = std::cmp::max(max, i - prev);
        return max as i32;
    }

    pub fn length_of_longest_substring1(s: String) -> i32 {
        let length = s.len();
        if length == 0 {
            return 0;
        }

        let bytes = s.as_bytes();
        let mut max = 1;
        let mut chars = std::collections::HashMap::new();
    
        for i in 0..length {
            chars = std::collections::HashMap::new();
            chars.insert(bytes[i], 0);

            for j in (i+1)..length {
                if chars.contains_key(&bytes[j]) {
                    break;
                }
                chars.insert(bytes[j], 0);
                max = std::cmp::max(max, chars.len());
            }
        }

        return max as i32;
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0003() {
        assert_eq!(Solution::length_of_longest_substring(String::from("12")), 2);
        assert_eq!(Solution::length_of_longest_substring(String::from("abcdce")), 4);
        assert_eq!(Solution::length_of_longest_substring(String::from("abacdce")), 4);
    }
}