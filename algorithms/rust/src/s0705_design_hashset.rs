struct MyHashSet {
    values: Vec<i32>
}


/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl MyHashSet {

    /** Initialize your data structure here. */
    fn new() -> Self {
        Self {
            values: vec![0; 1000001],
        }
    }

    fn add(&mut self, key: i32) {
        self.values[key as usize] = 1;
    }

    fn remove(&mut self, key: i32) {
        self.values[key as usize] = 0;
    }

    /** Returns true if this set contains the specified element */
    fn contains(&self, key: i32) -> bool {
        self.values[key as usize] == 1
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * let obj = MyHashSet::new();
 * obj.add(key);
 * obj.remove(key);
 * let ret_3: bool = obj.contains(key);
 */

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0705() {
        let mut obj = MyHashSet::new();
        obj.add(1);
        obj.add(2);
        assert_eq!(obj.contains(1), true);

        obj.remove(1);
        assert_eq!(obj.contains(1), false);

        obj.add(1);
        assert_eq!(obj.contains(1), true);
    }
}