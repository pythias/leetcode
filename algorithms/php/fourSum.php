<?php
/**
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 *     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 *     A solution set is:
 *     (-1,  0, 0, 1)
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 * 
 * @author:pythias@gmail.com
 */

class Solution {
    private function _twoSum($num, $start, $target) {
        $size = count($num);
        $twoResults = array();
        $j = $start;
        $k = $size - 1;

        while ($k > $j) {
            if ($j > $start && $num[$j] == $num[$j - 1]) {
                $j++;
                continue;
            }

            if ($k < $size - 2 && $num[$k] == $num[$k + 1]) {
                $k--;
                continue;
            }

            $sum = $num[$j] + $num[$k];
            if ($sum == $target) {
                $twoResults[] = array($num[$j], $num[$k]);
                $j++;
            } elseif ($sum > $target) {
                $k--;
            } else {
                $j++;
            }
        }

        return $twoResults;
    }

    private function _threeSum($num, $start, $target) {
        $size = count($num);
        $threeResults = array();

        for ($i = $start; $i < $size; $i++) {
            if ($i > $start && $num[$i] == $num[$i - 1]) {
                continue;
            }

            $twoResults = $this->_twoSum($num, $i + 1, $target - $num[$i]);
            foreach ($twoResults as $twoResult) {
                array_unshift($twoResult, $num[$i]);
                $threeResults[] = $twoResult;
            }
        }

        return $threeResults;
    }

    public function fourSum($num, $target) {
        $values = array();
        $size = count($num);
        if ($size < 4) {
            return $values;
        }

        sort($num);

        for ($i = 0; $i < $size; $i++) {
            if ($i > 0 && $num[$i] == $num[$i - 1]) {
                continue;
            }

            $threeResults = $this->_threeSum($num, $i + 1, $target - $num[$i]);
            foreach ($threeResults as $threeResult) {
                array_unshift($threeResult, $num[$i]);
                $values[] = $threeResult;
            }
        }

        return $values;
    }
}

$sol = new Solution();
var_dump($sol->fourSum(array(1, 0, -1, 0, -2, 2), 0));
