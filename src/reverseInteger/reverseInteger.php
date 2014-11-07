<?php
/**
 *
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * @author:pythias@gmail.com
 */

class Solution {
    public function reverse($x) {
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
$sol->reverse(123);
$sol->reverse(-321);
$sol->reverse(1000000008);
$sol->reverse(-1000000008);
