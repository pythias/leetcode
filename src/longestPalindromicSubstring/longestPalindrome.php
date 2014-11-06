<?php
/**
 *
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * 
 * @author:pythias@gmail.com
 */

class Solution {
    private function _isPalindrome($value) {
        $length = strlen($value);
        $midLength = intval($length / 2) + $length % 2;

        for ($i = 0; $i < $midLength; $i++) {
            if ($value[$i] !== $value[$length - $i - 1]) {
                return false;
            }
        }

        return true;
    }

    private function _longestPalindrome($value) {
        $length = strlen($value);
        for ($i = 0; $i < $length; $i++) { 
            $subLength = $length - $i;
            for ($j = 0; $j <= $i; $j++) { 
                $subString = substr($value, $j, $subLength);
                if ($this->_isPalindrome($subString)) {
                    return $subString;
                }
            }
        }

        return '';        
    }

    public function longestPalindrome($s) {
        echo "source string:'{$s}', longest palindrome string:'" . $this->_longestPalindrome($s) . "'\r\n";
    }
}

$sol = new Solution();
$sol->longestPalindrome('123432457');
$sol->longestPalindrome('1411234321');
$sol->longestPalindrome(str_repeat('abcdeedcba', 100));
