<?php
/**
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * @author:pythias@gmail.com
 */

class Solution {
    public function longestCommonPrefix($strs) {
        if (empty($strs)) {
            return '';
        }

        $size = count($strs);
        if ($size == 1) {
            return $strs[0];
        }

        $len = strlen($strs[0]);
        for ($j = 1; $j < $size; $j++) { 
            $len = min($len, strlen($strs[$j]));
        }

        $prefix = array();
        for ($i = 0; $i < $len; $i++) { 
            $c = $strs[0][$i];
            for ($j = 1; $j < $size; $j++) { 
                if ($strs[$j][$i] != $c) {
                    return implode('', $prefix);
                }
            }
            $prefix[] = $c;
        }

        return '';
    }
}

$sol = new Solution();
echo $sol->longestCommonPrefix(array('abcd', 'abce', 'abcde')) . "\r\n";
