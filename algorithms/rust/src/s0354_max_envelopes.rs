impl Solution {
    pub fn max_envelopes(envelopes: Vec<Vec<i32>>) -> i32 {
        let mut first = Envelope::new(&envelopes[0]);
        for i in 1..envelopes.len() {
            first.insert(&envelopes[i]);
        }
        first.get_dept()
    }
}

struct Envelope {
    width: i32,
    height: i32,
    outer: Option<Box<Envelope>>,
    inner: Option<Box<Envelope>>,
}

impl Envelope {
    fn new(v: &Vec<i32>) -> Self {
        Envelope {
            width: v[0],
            height: v[1],
            outer: None,
            inner: None
        }
    }

    fn insert(&mut self, v: &Vec<i32>) -> bool {
        match self.inner_or_outer(v) {
            1 => self.outer = Option::Some(Box::new(Envelope::new(v))),
            2 => self.inner = Option::Some(Box::new(Envelope::new(v))),
            _ => return false
        }

        true
    }

    fn get_dept(&mut self) -> i32 {
        //1 + self.get_outers() + self.get_inners()
        1
    }

    fn get_outers(&mut self) -> i32 {
        if self.outer.is_none() {
            return 0;
        }

        return self.get_outers() + 1;
    }

    fn get_inners(&mut self) -> i32 {
        if self.inner.is_none() {
            return 0;
        }

        return self.get_inners() + 1;
    }

    fn inner_or_outer(&self, v: &Vec<i32>) -> u8 {
        if self.width > v[0] && self.height > v[1] {
            return 1;
        }

        if self.width < v[0] && self.height < v[1] {
            return 2;
        }

        0
    }
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0354() {
        assert_eq!(Solution::max_envelopes(vec![vec![5,4],vec![6,4],vec![6,7],vec![2,3]]), 3);
        assert_eq!(Solution::max_envelopes(vec![vec![5,4],vec![6,4],vec![6,7],vec![1,5]]), 2);
        assert_eq!(Solution::max_envelopes(vec![vec![1,1],vec![1,1],vec![1,1]]), 1);
    }
}