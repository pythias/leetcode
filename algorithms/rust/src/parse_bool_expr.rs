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

fn parse_bool_expr(op: u8, chars: &[u8], offset: &mut usize) -> bool {
    let mut v: Option<bool> = None;
    let mut op1: u8 = 0;
    loop {
        if *offset >= chars.len() {
            return value(v);
        }

        let c = chars[*offset];
        *offset += 1;

        match c {
            b'(' => v = ops(op, v, parse_bool_expr(op1, chars, offset)),
            b')' => return value(v),
            b'&' | b'|' | b'!' => op1 = c,
            b't' => v = ops(op, v, true),
            b'f' => v = ops(op, v, false),
            b',' => { },
            _ => return value(v),
        }
    }
}

fn value(v: Option<bool>) -> bool {
    v.eq(&Some(true))
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

fn ops(op: u8, v0: Option<bool>, v1: bool) -> Option<bool> {
    match op {
        b'|' => or(v0, v1),
        b'&' => and(v0, v1),
        b'!' => Some(!v1),
        0 => Some(v1),
        _ => v0,
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