<?php
/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * @author:pythias@gmail.com
 * 
 */
class Solution {
    public function isValid(string $s) {
        $stack = array();
        $size = strlen($s);
        for ($i = 0; $i < $size; $i++) { 
            $char = $s[$i];
            if ($char == '(' || $char == '[' || $char == '{') {
                $stack[] = $char;
                continue;
            }

            if ($char == ')') {
                if (array_pop($stack) != '(') {
                    return false;
                }
            } elseif ($char == ']') {
                if (array_pop($stack) != '[') {
                    return false;
                }
            } elseif ($char == '}') {
                if (array_pop($stack) != '{') {
                    return false;
                }
            }
        }

        return count($stack) == 0;
    }
}

$sol = new Solution();
$strings = array("[ABC]{DEF}(GHI)", "{A[(.) | (.)]C}", "{A[B}C]", "{A[B]}C]");
foreach ($strings as $string) {
    echo '"' . $string . '" ' . ($sol->isValid($string) ? 'valid' : 'invalid') . PHP_EOL;
}
