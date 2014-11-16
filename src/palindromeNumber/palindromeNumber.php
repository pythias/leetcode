<?php
/**
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author:pythias@gmail.com
 */

class Solution {
    public function isPalindrome($x) {
        $isNegative = $x < 0;
        $count = 0;
        $value = abs($x);
        $numbers = array();
        while ($value >= 10) {
            $numbers[$count] = $value % 10;
            $value = floor($value / 10);
            $count++;
        }
        $numbers[$count] = $value;

        $y = 0;
        foreach ($numbers as $index => $number) {
            $tmpValue = $number * pow(10, $count - $index);
            if ((!$isNegative && ($tmpValue > PHP_INT_MAX || PHP_INT_MAX - $y < $tmpValue)) || 
                ($isNegative && ($tmpValue - 1 > PHP_INT_MAX || PHP_INT_MAX - $y < $tmpValue - 1))) {
                echo "ERR: {$x} reverse value is out of range\r\n";
                return;
            }

            $y += $number * pow(10, $count - $index);
        }

        if ($isNegative) {
            $y = -$y;
        }

        echo "{$x} => {$y}\r\n";
    }
}

//define('PHP_INT_MIN', ~PHP_INT_MAX);
$sol = new Solution();
$sol->isPalindrome(123);
$sol->isPalindrome(-321);
$sol->isPalindrome(1000000008);