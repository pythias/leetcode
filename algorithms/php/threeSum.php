<?php
/**
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 *     For example, given array S = {-1 0 1 2 -1 -4},
 * 
 *     A solution set is:
 *     (-1, 0, 1)
 *     (-1, -1, 2)
 * 
 * @author:pythias@gmail.com
 */

class Solution {
    public function threeSum($num) {
        $values = array();
        $size = count($num);
        if ($size < 3) {
            return $values;
        }

        sort($num);

        for ($i = 0; $i < $size; $i++) {
            //去重P1
            if ($i > 0 && $num[$i] == $num[$i - 1]) {
                continue;
            }

            $p1 = $num[$i];
            $j = $i + 1;
            $k = $size - 1;
            while ($k > $j) {
                //去重P2
                if ($j > $i + 1 && $num[$j] == $num[$j - 1]) {
                    $j++;
                    continue;
                }

                //去重P3
                if ($k < $size - 2 && $num[$k] == $num[$k + 1]) {
                    $k--;
                    continue;
                }

                $sum = $p1 + $num[$j] + $num[$k];
                if ($sum == 0) {
                    $values[] = array($p1, $num[$j], $num[$k]);
                    $j++;
                } elseif ($sum > 0) {
                    $k--;
                } else {
                    $j++;
                }
            }
        }

        return $values;
    }
}

$sol = new Solution();
var_dump($sol->threeSum(array(-1, 0, 1, 2, -1, -4)));
