<?php
/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 * 
 *    Given linked list: 1->2->3->4->5, and n = 2.
 * 
 *    After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * @author:pythias@gmail.com
 * 
 */

class ListNode {
    public $value;
    public $next;

    public function __construct($value = null, $next = null) {
        $this->value = $value;
        $this->next = $next;
    }

    public function __toString() {
        return $this->next ? "{$this->value} -> {$this->next}" : "{$this->value}";
    }
}

class Solution {
    public function removeNthFromEnd(&$head, $n) {
        $current = $head;
        $list1 = $head;
        $list2 = $head;

        for ($i = 0; $i < $n; $i++) { 
            $list1 = $list1->next;
        }

        while ($list1) {
            $current = $list2;
            $list1 = $list1->next;
            $list2 = $list2->next;
        }

        $current->next = $list2->next;
    }
}

$head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
$sol = new Solution();
$sol->removeNthFromEnd($head, 2);
echo $head;
