/**
 * 1108. Defanging an IP Address
 * https://leetcode.com/problems/defanging-an-ip-address/
 */
impl Solution {
    pub fn defang_i_paddr(address: String) -> String {
        let parts: Vec<_> = address.split('.').collect();
        if parts.len() != 4 {
            return String::from("");
        }

        for i in 0..4 {
            let t: i32 = String::from(parts[i]).parse().unwrap();
            if t < 0 || t > 255 {
                return String::from("");
            }
        }

        return parts.join("[.]");
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_1108() {
        assert_eq!(Solution::defang_i_paddr(String::from("1.0.0.0")), "1[.]0[.]0[.]0");
        assert_eq!(Solution::defang_i_paddr(String::from("1.255.0.0")), "1[.]255[.]0[.]0");
    }
}