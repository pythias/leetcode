impl Solution {
    pub fn reverse(x: i32) -> i32 {
        if x == 0 {
            return 0;
        }

        let ten: i64 = 10;
        let mut y: f64 = (x as f64).abs();
        let size: u32 = y.log10().floor() as u32;
        let mut rev: i64 = 0;
        for i in (0..size+1).rev() {
            rev += ((y % 10.0) as i64) * ten.pow(i);
            y = y / 10.0;
        }

        if rev > i32::max_value().into() {
            return 0;
        }

        return if x < 0 { 
            -rev as i32
        } else { 
            rev as i32
        };
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn reverse() {
        assert_eq!(321, Solution::reverse(123));
        assert_eq!(-54, Solution::reverse(-450));
        
        assert_eq!(0, Solution::reverse(2147483647));
        assert_eq!(0, Solution::reverse(-2147483648));
    }
} 