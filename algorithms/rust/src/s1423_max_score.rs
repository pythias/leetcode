impl Solution {
    pub fn max_score(card_points: Vec<i32>, k: i32) -> i32 {
        let length = card_points.len() as usize;
        let uk = k as usize;
        let mut sum = 0;
        for i in 0..uk {
            sum += card_points[i];
        }

        let mut max = sum;
        for i in 0..uk {
            sum += card_points[length - i - 1] - card_points[uk - i - 1];
            max = std::cmp::max(max, sum);
        }

        return max;
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_1423() {
        assert_eq!(Solution::max_score(vec![100,40,17,9,73,75], 3), 248);
        assert_eq!(Solution::max_score(vec![1, 2, 3], 3), 6);
        assert_eq!(Solution::max_score(vec![2, 2, 2], 2), 4);
        assert_eq!(Solution::max_score(vec![1, 2, 3, 4, 5, 6, 1], 3), 12);
    }
}