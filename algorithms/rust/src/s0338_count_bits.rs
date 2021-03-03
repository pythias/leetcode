impl Solution {
    pub fn count_bits(num: i32) -> Vec<i32> {
        let mut exp = (num as f64).log2() as u32;
        let mut bits = get_bits(exp);

        bits.truncate((num + 1) as usize);
        bits
    }
}


fn get_bits(exp: u32) -> Vec<i32> {
    if exp == 0 {
        return vec![0, 1];
    }

    let mut bits = Vec::new();
    let mut first = get_bits(exp - 1);
    let mut second = first.iter().map(|i| i + 1).collect::<Vec<i32>>();
    bits.append(&mut first);
    bits.append(&mut second);
    bits
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0338() {
        assert_eq!(Solution::count_bits(2), vec![0,1,1]);
        assert_eq!(Solution::count_bits(5), vec![0,1,1,2,1,2]);
        assert_eq!(Solution::count_bits(8), vec![0,1,1,2,1,2,2,3,1]);
    }
}
