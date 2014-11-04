<?php
/**
 * Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * @author:pythias@gmail.com
 */

class Solution {
    public function lengthOfLongestSubstring($s) {
        $length = strlen($s);
        $begin = 0;
        $end = 0;
        $substrings = array();
        $sizes = array();
        $offset = 0;

        while (true) { 
            $char = $s[$offset];

            if (isset($substrings[$char])) {
                $sizes[$begin] = $offset - $begin;
                $begin = $substrings[$char] + 1;
                $offset = $substrings[$char];
                $substrings = array();
            } else {
                $substrings[$char] = $offset;
            }

            $offset++;

            if ($offset >= $length) {
                $sizes[$begin] = $offset - $begin;
                break;
            }
        }

        $theBegin = 0;
        $longest = 0;
        foreach ($sizes as $begin => $size) {
            if ($size > $longest) {
                $longest = $size;
                $theBegin = $begin;
            }
        }

        echo "'{$s}' => '" . substr($s, $theBegin, $longest) . "'\r\n";
    }
}

$sol = new Solution();
$sol->lengthOfLongestSubstring('abcac');
$sol->lengthOfLongestSubstring('abcbadabba');
$sol->lengthOfLongestSubstring('aaa');
