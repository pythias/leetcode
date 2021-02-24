impl Solution {
    pub fn flip_and_invert_image(a: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let mut b = Vec::new();
        for mut item in a {
            item.reverse();
            for i in 0..item.len() {
                if item[i] == 1 {
                    item[i] = 0;
                } else {
                    item[i] = 1;
                }
            }
            b.push(item);
        }
        return b;
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0832() {
        
        let mut a = Vec::new();
        a.push(vec![1, 1, 0]);
        a.push(vec![0, 0, 0]);
        a.push(vec![1, 1, 1]);

        
        let mut b = Vec::new();
        b.push(vec![1, 0, 0]);
        b.push(vec![1, 1, 1]);
        b.push(vec![0, 0, 0]);
        assert_eq!(b, Solution::flip_and_invert_image(a));
    }
}