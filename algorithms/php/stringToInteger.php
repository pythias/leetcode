<?php
/**
 *
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 * 
 * @author:pythias@gmail.com
 */

class Solution {
    public function atoi($str) {
        $isNegative = false;
        $newStr = trim($str);
        $len = strlen($newStr);
        if ($str[0] == '-') {
            $len--;
            $newStr = substr($newStr, 1);
            $isNegative = true;
        }

        $size = 0;
        $ords = array();
        for ($i = 0; $i < $len; $i++) { 
            $char = $newStr[$i];
            $ord = ord($char);
            if ($ord < 48 || $ord > 57) {
                break;
            }
            
            $ords[$size++] = $ord;
        }

        $int = 0;
        foreach ($ords as $index => $ord) {
            $tmpValue = ($ord - 48) * pow(10, $size - $index - 1);
            if ((!$isNegative && ($tmpValue > PHP_INT_MAX || PHP_INT_MAX - $int < $tmpValue)) || 
                ($isNegative && ($tmpValue - 1 > PHP_INT_MAX || PHP_INT_MAX - $int < $tmpValue - 1))) {
                echo "ERR: {$str} value is out of range\r\n";
                return;
            }

            $int += $tmpValue;
        }

        if ($isNegative) {
            $int = -$int;
        }

        echo "{$str} => {$int}\r\n";
    }
}

//define('PHP_INT_MIN', ~PHP_INT_MAX);
$sol = new Solution();
$sol->atoi("123x4");
$sol->atoi("-321");
$sol->atoi("8000000001");
$sol->atoi("-8000000001");
$sol->atoi("1x8000000001");
$sol->atoi("-1x8000000001");
