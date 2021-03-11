impl Solution {
    pub fn calculate(s: String) -> i32 {
        let mut bytes = s.into_bytes();
        Self::do_calculate(&mut bytes)
    }

    fn do_calculate(bytes: &mut Vec<u8>) -> i32 {
        let mut operator = Operator::Empty;
        let mut result = 0;
        let mut last = 0;
        loop {
            let byte = bytes.first().unwrap();
            match Self::get_element(*byte) {
                Element::Left => {
                    bytes.remove(0);
                    last = Self::do_calculate(bytes);
                    result = Self::do_operator(result, last, &operator);
                    operator = Operator::Empty;
                }
                Element::Right => {
                    bytes.remove(0);
                    return result;
                }
                Element::Number(_) => {
                    last = Self::do_number(bytes);
                    result = Self::do_operator(result, last, &operator);
                    operator = Operator::Empty;
                }
                Element::Plus => {
                    bytes.remove(0);
                    match operator {
                        Operator::Plus | Operator::Empty => {
                            operator = Operator::Plus;
                        }
                        Operator::Minus => {
                            operator = Operator::Minus;
                        }
                    }
                }
                Element::Minus => {
                    bytes.remove(0);
                    match operator {
                        Operator::Plus | Operator::Empty => {
                            operator = Operator::Minus;
                        }
                        Operator::Minus => {
                            operator = Operator::Plus;
                        }
                    }
                }
                Element::Space | Element::Nothing => {
                    bytes.remove(0);
                }
            }

            if bytes.is_empty() {
                break;
            }
        }
        result
    }

    fn do_number(bytes: &mut Vec<u8>) -> i32 {
        let mut numbers = "0".to_string();
        loop {
            if bytes.is_empty() {
                return numbers.parse::<i32>().unwrap();
            }

            let byte = bytes.first().unwrap();
            match Self::get_element(*byte) {
                Element::Number(c) => {
                    bytes.remove(0);
                    numbers.push(c);
                }
                Element::Left | Element::Right | Element::Plus | Element::Minus => {
                    return numbers.parse::<i32>().unwrap();
                }
                Element::Space => {
                    bytes.remove(0);
                }
                Element::Nothing => {}
            }
        }
    }

    fn do_operator(left: i32, right: i32, operator: &Operator) -> i32 {
        let mut result = left;
        match operator {
            Operator::Plus => {
                result += right;
            },
            Operator::Minus => {
                result -= right;
            },
            Operator::Empty => {
                result = right;
            },
        }

        result
    }

    fn get_element(byte: u8) -> Element {
        match byte {
            32 => Element::Space,
            40 => Element::Left,
            41 => Element::Right,
            43 => Element::Plus,
            45 => Element::Minus,
            48..=57 => Element::Number(byte as char),
            _ => Element::Nothing,
        }
    }
}

#[derive(Debug)]
enum Operator {
    Plus, Minus, Empty
}

#[derive(Debug)]
enum Element {
    Left, Right, Number(char), Plus, Minus, Space, Nothing
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0224() {
        assert_eq!(Solution::calculate(String::from("1+(1+2)")), 4);
        assert_eq!(Solution::calculate(String::from("1-(1+2)")), -2);
        assert_eq!(Solution::calculate(String::from("(11+21)")), 32);
        assert_eq!(Solution::calculate(String::from("-(1+2)")), -3);
        assert_eq!(Solution::calculate(String::from("-1 - -1")), 0);
        assert_eq!(Solution::calculate(String::from("1 + 1")), 2);
        assert_eq!(Solution::calculate(String::from("-1 + 1")), 0);
        assert_eq!(Solution::calculate(String::from(" 2-1 + 2 ")), 3);
        assert_eq!(Solution::calculate(String::from("(1+(4+5+2)-3)+(6+8)")), 23);
    }
}