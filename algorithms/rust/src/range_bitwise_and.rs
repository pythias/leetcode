impl Solution {
    pub fn range_bitwise_and(m: i32, n: i32) -> i32 {
        if n < m {
            return 0;
        }

        if m < 0 {
            return 0;
        }

        if m == n {
            return m;
        }

        let f0 = (m as f32).log2().floor() as i32;
        let f1 = (n as f32).log2().floor() as i32;
        if (f1 - f0) >= 1 {
            return 0;
        }

        let mut x = 0;
        for i in (0..(f1 + 1)).rev() {
            let t = 1 << i;
            if (t & n) != (t & m) {
                return m & n & x;
            }

            x += t;
        }

        0
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test0() {
        assert_eq!(Solution::range_bitwise_and(5, 7), 4);
    }

    #[test]
    fn test1() {
        assert_eq!(Solution::range_bitwise_and(5, 6), 4);
    }

    #[test]
    fn test2() {
        assert_eq!(Solution::range_bitwise_and(5, 8), 0);
    }

    #[test]
    fn test3() {
        assert_eq!(Solution::range_bitwise_and(6, 7), 6);
    }

    #[test]
    fn test4() {
        assert_eq!(Solution::range_bitwise_and(2147483646, 2147483647), 2147483646);
    }
}