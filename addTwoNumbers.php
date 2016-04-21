<?php
/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *  
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * @author:pythias@gmail.com
 */

class LinkNode {
    public $value;
    public $next;
    public function __construct($x) {
        $this->value = $x;
        $this->next = null;
    }

    public function getSize() {
        $size = 1;
        $next = $this->next;
        while ($next) {
            $size++;
            $next = $next->next;
        }

        return $size;
    }

    public function getNumber($reverse = true) {
        $index = $reverse ? $this->getSize() - 1 : 0;
        $step = $reverse ? -1 : 1;
        $number = $this->value * pow(10, $index);
        $next = $this->next;
        while ($next) {
            $index = $index + $step;
            $number += $next->value * pow(10, $index);
            $next = $next->next;
        }

        return $number;
    }

    public function __toString() {
        $values = array($this->value);
        $next = $this->next;
        while ($next) {
            $values[] = $next->value;
            $next = $next->next;
        }

        return implode(' -> ', $values);
    }
}

class Solution {
    public function addTwoNumbers(LinkNode $l1, LinkNode $l2) {
        $last = $l3 = null;
        $value = $l1->getNumber() + $l2->getNumber(false);
        $value = strval($value);
        $length = strlen($value);

        for ($i = 0; $i < $length; $i++) {
            $node = new LinkNode(intval($value[$i]));
            if ($last) {
                $last->next = $node;
            }

            if ($l3 == null) {
                $l3 = $node;
            }

            $last = $node;
        }

        echo $l3;
    }
}

$l1 = new LinkNode(2);
$l1->next = new LinkNode(4);
$l1->next->next = new LinkNode(3);

$l2 = new LinkNode(5);
$l2->next = new LinkNode(6);
$l2->next->next = new LinkNode(4);

$sol = new Solution();
$sol->addTwoNumbers($l1, $l2);
