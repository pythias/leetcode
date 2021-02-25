//https://leetcode.com/problems/transpose-matrix/
impl Solution {
    pub fn transpose(matrix: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let mut b = Vec::new();
        for _col in 0..matrix[0].len() {
            b.push(Vec::new());
        }

        for row in 0..matrix.len() {
            for col in 0..matrix[row].len() {
                b[col].push(matrix[row][col]);
            }
        }
        return b;
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0867() {
        
        let mut a = Vec::new();
        a.push(vec![1, 2, 3]);
        a.push(vec![4, 5, 6]);
        a.push(vec![7, 8, 9]);

        let mut b = Vec::new();
        b.push(vec![1, 4, 7]);
        b.push(vec![2, 5, 8]);
        b.push(vec![3, 6, 9]);
        assert_eq!(b, Solution::transpose(a));
        
        a = Vec::new();
        a.push(vec![1, 2, 3]);
        a.push(vec![4, 5, 6]);

        b = Vec::new();
        b.push(vec![1, 4]);
        b.push(vec![2, 5]);
        b.push(vec![3, 6]);
        assert_eq!(b, Solution::transpose(a));
    }
}