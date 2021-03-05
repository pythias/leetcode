struct MyQueue {
    list: Vec<i32>
}


/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl MyQueue {

    /** Initialize your data structure here. */
    fn new() -> Self {
        Self {
            list: Vec::new()
        }
    }

    /** Push element x to the back of queue. */
    fn push(&mut self, x: i32) {
        self.list.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    fn pop(&mut self) -> i32 {
        let v = self.list[0];
        self.list.remove(0);
        v
    }

    /** Get the front element. */
    fn peek(&mut self) -> i32 {
        match self.list.is_empty() {
            true => 0,
            false => self.list[0]
        }
    }

    /** Returns whether the queue is empty. */
    fn empty(&mut self) -> bool {
        self.list.is_empty()
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * let obj = MyQueue::new();
 * obj.push(x);
 * let ret_2: i32 = obj.pop();
 * let ret_3: i32 = obj.peek();
 * let ret_4: bool = obj.empty();
 */

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_0232() {
        let mut my_queue = MyQueue::new();
        my_queue.push(0);
        my_queue.push(2);
        assert_eq!(my_queue.pop(), 2);
        assert_eq!(my_queue.pop(), 0);
        assert_eq!(my_queue.empty(), true);
    }
}
