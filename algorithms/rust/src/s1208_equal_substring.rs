// 1208. Get Equal Substrings Within Budget
// https://leetcode.com/problems/get-equal-substrings-within-budget/
impl Solution {
    pub fn equal_substring(s: String, t: String, max_cost: i32) -> i32 {
        let length = s.len();
        let s_bytes = s.as_bytes();
        let t_bytes = t.as_bytes();
        let mut cost = vec![];
        for i in 0..length {
            cost.push((s_bytes[i] as i32 - t_bytes[i] as i32).abs());
        }

        let mut max = 0;
        for i in 0..length {
            let mut sub = 0;
            let mut remain = max_cost;
            for j in i..length {
                if remain < cost[j] {
                    break;
                }
                
                remain -= cost[j];
                sub += 1;
                max = std::cmp::max(max, sub);
            }
        }

        return max;
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test_1208() {
        assert_eq!(Solution::equal_substring(String::from("pxezla"), String::from("loewbi"), 25), 4);
        assert_eq!(Solution::equal_substring(String::from("krpgjbjjznpzdfy"), String::from("nxargkbydxmsgby"), 14), 4);
        assert_eq!(Solution::equal_substring(String::from("abcd"), String::from("acde"), 0), 1);
    }
}