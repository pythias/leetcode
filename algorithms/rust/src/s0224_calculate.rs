impl Solution {
    pub fn calculate(s: String) -> i32 {
        let mut stack = Vec::new();
        let mut left = 0;
        let mut right  = 0;
        let mut sign = 1;
        let mut operator = Operator::Empty;
        for c in s.bytes() {
            match c {
                b'+' => {
                    left += right * sign;
                    right = 0;
                    sign = 1;
                    operator = Operator::Minus;
                }
                b'-' => {
                    left += right * sign;
                    right = 0;
                    sign = -1;
                    operator = Operator::Plus;
                }
                b'*' => {
                    stack.push((left, Operator::Multiply));
                    left = 0;
                }
                b'/' => {
                    stack.push((left, Operator::Divide));
                    left = 0;
                }
                b'0'..=b'9' => {
                    right = right * 10 + i32::from(c - b'0');
                }
                _ => {}
            }
        }

        0
    }
}

enum Operator {
    Plus, Minus, Multiply, Divide, Empty
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0224() {
        assert_eq!(Solution::calculate(String::from("1 +3 *2 / 2 + 3")), 7);
        assert_eq!(Solution::calculate(String::from("1 +2 *3 / 2 + 3")), 7);
        assert_eq!(Solution::calculate(String::from("1 +2 *3 / -2 + 3")), 1);
    }
}