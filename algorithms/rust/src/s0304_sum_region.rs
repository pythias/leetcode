struct NumMatrix {
    pub sums: Vec<Vec<i32>>
}

/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl NumMatrix {

    fn new(matrix: Vec<Vec<i32>>) -> Self {
        if matrix.len() == 0 {
            return Self {
                sums: vec![]
            };
        }

        let mut sums = vec![vec![0; matrix[0].len() + 1]; matrix.len()];
        for i in 0..matrix.len() {
            for j in 0..matrix[0].len() {
                sums[i][j + 1] = sums[i][j] + matrix[i][j];
            }
        }

        Self {
            sums
        }
    }

    fn sum_region(&self, row1: i32, col1: i32, row2: i32, col2: i32) -> i32 {
        let mut sum = 0;
        for i in row1..(row2 + 1) {
            sum += self.sums[i as usize][(col2 + 1) as usize] -  self.sums[i as usize][col1 as usize];
        }

        sum
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * let obj = NumMatrix::new(matrix);
 * let ret_1: i32 = obj.sum_region(row1, col1, row2, col2);
 */

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0304() {
        let mut num_matrix = NumMatrix::new(vec![
            vec![3, 0, 1, 4, 2],
            vec![5, 6, 3, 2, 1],
            vec![1, 2, 0, 1, 5],
            vec![4, 1, 0, 1, 7],
            vec![1, 0, 3, 0, 5]
        ]);
        assert_eq!(num_matrix.sum_region(2, 1, 4, 3), 8);
        assert_eq!(num_matrix.sum_region(1, 1, 2, 2), 11);
        assert_eq!(num_matrix.sum_region(1, 2, 2, 4), 12);

        num_matrix = NumMatrix::new(vec![vec![4, 5]]);
        assert_eq!(num_matrix.sum_region(0, 0,0, 0), 4);

        num_matrix = NumMatrix::new(vec![vec![0]]);
        assert_eq!(num_matrix.sum_region(0, 0,0, 0), 0);
    }
}
