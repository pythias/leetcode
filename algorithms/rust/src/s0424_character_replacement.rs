/**
 * 424. Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 */

use std::cmp::max;

impl Solution {
    pub fn character_replacement(s: String, k: i32) -> i32 {        
        let length = s.len();
        let byes = s.as_bytes();
        let mut counts = [0; 26];
        let mut left = 0;
        let mut right = 0;
        let mut max1 = 0;
        let k_usize = k as usize;
        loop {
            if right >= length {
                return (right - left) as i32;
            }
            
            let i = ord(byes[right]);
            counts[i] += 1;
            max1 = max(max1, counts[i]);
            if (right - left + 1) > (max1 + k_usize) {
                let j = ord(byes[left]);
                counts[j] -= 1;
                left += 1;
            }

            right += 1;
        }
    }
}

fn ord(b: u8) -> usize {
    return (b - 65) as usize;
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test_0424() {
        assert_eq!(Solution::character_replacement(String::from("ABAB"), 2), 4);
        assert_eq!(Solution::character_replacement(String::from("AABABBA"), 1), 4);
    }
}