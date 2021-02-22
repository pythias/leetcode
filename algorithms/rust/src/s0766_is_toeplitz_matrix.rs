impl Solution {
    pub fn is_toeplitz_matrix(matrix: Vec<Vec<i32>>) -> bool {
        let rows = matrix.len();
        let cols = matrix[0].len();
        for i in 1..rows {
            for j in 1..cols {
                if matrix[i][j] != matrix[i-1][j-1] {
                    return false;
                }
            }
        }

        return true;
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0766() {
        
        let mut matrix = Vec::new();
        matrix.push(vec![1, 2, 3]);
        matrix.push(vec![4, 1, 2]);
        matrix.push(vec![1, 4, 1,]);
        assert_eq!(true, Solution::is_toeplitz_matrix(matrix));

        matrix = Vec::new();
        matrix.push(vec![1, 2, 3]);
        matrix.push(vec![4, 1, 2]);
        assert_eq!(true, Solution::is_toeplitz_matrix(matrix));

        matrix = Vec::new();
        matrix.push(vec![1, 2]);
        matrix.push(vec![1, 2]);
        assert_eq!(false, Solution::is_toeplitz_matrix(matrix));
    }
}