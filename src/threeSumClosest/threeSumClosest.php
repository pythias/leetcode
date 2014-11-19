<?php
/**
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 *     For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 *     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author:pythias@gmail.com
 */

class Solution {
    public function threeSumClosest($num, $target) {
        $sum = 0;
        $size = count($num);
        if ($size < 3) {
            return $values;
        }

        $closest = $num[0] + $num[1] + $num[2] - $target;
        sort($num);

        for ($i = 0; $i < $size; $i++) {
            $p1 = $num[$i];
            $j = $i + 1;
            $k = $size - 1;

            while ($k > $j) {
                $sum = $p1 + $num[$j] + $num[$k];
                if (abs($sum - $target) < abs($closest)) {
                    $closest = $sum - $target;
                }

                if ($sum == $target) {
                    return $sum;
                }

                if ($sum > $target) {
                    $k--;
                } else {
                    $j++;
                }
            }
        }

        return $target + $closest;
    }
}

$sol = new Solution();
echo $sol->threeSumClosest(array(-1, 2, 1, -4), 1);
