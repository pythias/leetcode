impl Solution {
    pub fn parse_bool_expr(expression: String) -> bool {
        let len: usize = expression.len();
        if len == 0 || len > 20000 {
            return false;
        }

        let mut offset: usize = 0;
        return parse_bool_expr(0,expression.as_bytes(), &mut offset);
    }
}

const LEFT: u8 = 40;
const RIGHT: u8 = 41;
const COMMA: u8 = 44;
const AND: u8 = 38;
const OR: u8 = 124;
const NOT: u8 = 33;
const TRUE: u8 = 116;
const FALSE: u8 = 102;

fn parse_bool_expr(op: u8, chars: &[u8], offset: &mut usize) -> bool {
    let mut v: Option<bool> = None;
    let mut op1: u8 = 0;
    loop {
        if *offset >= chars.len() {
            return v.eq(&Some(true));
        }

        let c = chars[*offset];
        *offset += 1;

        match c {
            LEFT => {
                let result= parse_bool_expr(op1, chars, offset);
                match op {
                    OR => {
                        v = or(v, result)
                    },
                    AND => {
                        v = and(v, result)
                    },
                    NOT => {
                        v = Some(!result);
                    },
                    0 => {
                        v = Some(result);
                    },
                    _ => {},
                }
            },
            RIGHT => {
                return v.eq(&Some(true));
            },
            AND | OR | NOT => { op1 = c },
            TRUE => {
                match op {
                    AND => v = and(v, true),
                    OR => v = or(v, true),
                    NOT => v = Some(false),
                    _ => v = Some(true),
                }
            },
            FALSE => {
                match op {
                    AND => v = and(v, false),
                    OR => v = or(v, false),
                    NOT => v =Some(true),
                    _ => v = Some(false),
                }
            },
            COMMA => { },
            _ => {
                return v.eq(&Some(true));
            },
        }
    }
}

fn or(v0: Option<bool>, v1: bool) -> Option<bool> {
    if v0.is_none() {
        Some(v1)
    } else {
        Some(v0.eq(&Some(true)) || v1)
    }
}

fn and(v0: Option<bool>, v1: bool) -> Option<bool> {
    if v0.is_none() {
        Some(v1)
    } else {
        Some(v0.eq(&Some(true)) && v1)
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test0() {
        assert_eq!(Solution::parse_bool_expr(String::from("!(t)")), false);
        assert_eq!(Solution::parse_bool_expr(String::from("|(f,t)")), true);
        assert_eq!(Solution::parse_bool_expr(String::from("|(f,f)")), false);
        assert_eq!(Solution::parse_bool_expr(String::from("&(t,f,t)")), false);
        assert_eq!(Solution::parse_bool_expr(String::from("|(&(t,f,t),!(t))")), false);
    }

    #[test]
    fn test1() {
        assert_eq!(Solution::parse_bool_expr(String::from("!(&(!(&(f)),&(t,f,t)))")), true);
    }

    #[test]
    fn test2() {
        assert_eq!(Solution::parse_bool_expr(String::from("!(&(&(!(&(f)),&(t),|(f,f,t)),&(t),&(t,t,f)))")), true);
    }
}