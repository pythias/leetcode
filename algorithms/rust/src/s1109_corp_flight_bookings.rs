/**
 * 1109. Corporate Flight Bookings
 * https://leetcode.com/problems/corporate-flight-bookings/
 */
impl Solution {
    pub fn corp_flight_bookings(bookings: Vec<Vec<i32>>, n: i32) -> Vec<i32> {
        let mut value = vec![0; n as usize];
        for booking in bookings {
            let (f, t, v) = (booking[0], booking[1], booking[2]);
            for i in (f-1)..std::cmp::min(t, n) {
                value[i as usize] += v;
            }
        }

        return value;
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_1109() {
        assert_eq!(Solution::corp_flight_bookings(vec![vec![1, 2, 10], vec![2, 3, 20], vec![2, 5, 25]], 5), vec![10, 55, 45, 25, 25]);
    }
}