//480. Sliding Window Median
//https://leetcode.com/problems/sliding-window-median/
impl Solution {
    pub fn median_sliding_window(nums: Vec<i32>, k: i32) -> Vec<f64> {
        let length = nums.len() as usize;
        let uk = k as usize;
        let mut middle = 0;
        let even = uk % 2 == 0;
        if even {
            middle = uk / 2;
        } else {
            middle = (uk  - 1)/ 2;
        }

        let mut median: Vec<f64> = vec![];
        let mut window: Vec<i32> = vec![];
        for i in 0..uk {
            window.push(nums[i]);
        }
        window.sort();
        median.push(get_median(&window, middle, even));
        
        for i in uk..length {
            let right = nums[i];
            if nums[i - uk] == right {
                median.push(get_median(&window, middle, even));
            } else {
                move_next(&mut window, nums[i - uk], right);
                median.push(get_median(&window, middle, even));
            }
        }

        return median;
    }
}

fn move_next(window: &mut Vec<i32>, left: i32, right: i32) {
    let mut left_index = 0;
    let mut right_index = 0;
    if left > right {
        right_index = 0;
        for i in 0..window.len() {
            if window[i] == left {
                left_index = i;
                break;
            }
    
            if window[i] < right {
                right_index = i + 1;
            }
        }
    } else {
        right_index = window.len();
        for i in 0..window.len() {
            if window[i] == left {
                left_index = i;
            }
    
            if window[i] >= right {
                right_index = i;
                break;
            }
        }
    }

    if right_index > left_index {
        window.insert(right_index, right);
        window.remove(left_index);
    } else {
        window.insert(right_index, right);
        window.remove(left_index + 1);
    }
}

fn get_median(window: &Vec<i32>, middle: usize, even: bool) -> f64 {
    if even {
        return (window[middle - 1] as f64 + window[middle] as f64) / 2.0;
    } else {
        return window[middle] as f64;
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0480() {
        assert_eq!(vec![2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000], Solution::median_sliding_window(vec![1,2,3,4,2,3,1,4,2], 3));
        assert_eq!(vec![1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000], Solution::median_sliding_window(vec![1,3,-1,-3,5,3,6,7], 3));
        assert_eq!(vec![2.0, 2.0], Solution::median_sliding_window(vec![3, 2, 2, 3], 3));
        assert_eq!(vec![3.0, 2.0], Solution::median_sliding_window(vec![3, 2, 4, 1], 3));
        assert_eq!(vec![2.0, 2.5], Solution::median_sliding_window(vec![2, 2, 3], 2));
    }
}