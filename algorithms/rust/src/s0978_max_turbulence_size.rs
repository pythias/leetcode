impl Solution {
    pub fn max_turbulence_size(arr: Vec<i32>) -> i32 {
        let len = arr.len();
        if len == 1 {
            return 1;
        }

        if len == 2 {
            if arr[0] == arr[1] {
                return 1;
            }

            return 2;
        }

        let mut c = 0;
        let mut t = get_eq(arr[0], arr[1]);
        let mut i = 1;
        let mut max = 0;
    
        if t != 0 {
            max = 2;
            c = 2;
        } else {
            max = 1;
            c = 1;
        }

        loop {
            i += 1;
            if (i >= len) {
                return max;
            }

            let nt = get_eq(arr[i - 1], arr[i]);
            if nt | t == 3 {
                c += 1;
                max = std::cmp::max(max, c);
                t = nt;
            } else {
                t = nt;
                c = 2;
            }
        }
    }
}

fn get_eq(a: i32, b: i32) -> i32 {
    if a == b {
        return 0;
    }

    if a > b {
        return 1;
    }
    
    return 2;
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0978() {
        assert_eq!(Solution::max_turbulence_size(vec![2, 7, 11, 5]), 3);
        assert_eq!(Solution::max_turbulence_size(vec![2, 7]), 2);
    }
}