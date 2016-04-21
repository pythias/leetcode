<?php
/**
 *
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * 
 * @author:pythias@gmail.com
 */

class Solution {
    private function _getExpressions($p) {
        $expressions = array();
        $lenP = strlen($p);
        for ($i = 0; $i < $lenP; $i++) { 
            $charP = $p[$i];
            if ($charP == '*') {
                continue;
            }

            if ($i + 1 < $lenP && $p[$i + 1] == '*') {
                $expressions[] = array('handle' => '_zeroOrMoreChar', 'char' => $charP);
                $i++;
            } else {
                $expressions[] = array('handle' => '_singleChar', 'char' => $charP);
            }
        }

        return $expressions;
    }

    private function _singleChar($s, $c) {
        if ($s[0] == $c || $c == '.') {
            return 0;
        }

        return false;
    }

    private function _zeroOrMoreChar($s, $c) {
        $len = strlen($s);

        for ($i = 0; $i < $len; $i++) {
            if ($s[$i] != $c && $c != '.') {
                return $i - 1;
            }
        }

        return $len - 1;
    }

    public function isMatch($s, $p) {
        $ns = $s;
        $expressions = $this->_getExpressions($p);
        foreach ($expressions as $expression) {
            if ($ns === false) {
                return false;
            }

            $index = $this->$expression['handle']($ns, $expression['char']);
            if ($index === false) {
                return false;
            }

            $ns = substr($ns, $index + 1);
        }

        return !$ns;
    }
}

$sol = new Solution();
echo $sol->isMatch("aa","a") ? "true\r\n" : "false\r\n";
echo $sol->isMatch("aa","aa") ? "true\r\n" : "false\r\n";
echo $sol->isMatch("a","aa") ? "true\r\n" : "false\r\n";
echo $sol->isMatch("aa", "a*") ? "true\r\n" : "false\r\n";
echo $sol->isMatch("aa", ".*") ? "true\r\n" : "false\r\n";
echo $sol->isMatch("ab", ".*") ? "true\r\n" : "false\r\n";
echo $sol->isMatch("aab", "c*a*b") ? "true\r\n" : "false\r\n";
echo $sol->isMatch("aa", ".b") ? "true\r\n" : "false\r\n";
echo $sol->isMatch("ab", ".b") ? "true\r\n" : "false\r\n";