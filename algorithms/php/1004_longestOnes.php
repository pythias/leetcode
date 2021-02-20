<?php
class Solution {
    /**
     * @param Integer[] $A
     * @param Integer $K
     * @return Integer
     */
    function longestOnes($A, $K) {
        return $K == 0 ? $this->_zero($A) : $this->_positive($A, $K);
    }

    private function _zero($nums) {
        $count = 0;
        $max = 0;
        foreach ($nums as $num) {
            if ($num == 0) {
                $count = 0;
                continue;
            }

            $count++;
            $max = max($max, $count);
        }

        return $max;
    }

    private function _positive($nums, $k) {
        $count = 0;
        $max = 0;
        $last = 0;
        $index = 0;
        $remain = $k;
        $length = count($nums);
        while ($index < $length) {
            if ($nums[$index] == 0) {
                $remain--;
                if ($remain == -1) {
                    $index = $last;
                    $remain = $k;
                    $count = 0;
                    $last = 0;
                    continue;
                } else if ($remain == ($k - 1)) {
                    $last = ($count == 0) ? ($index + 1) : $index;
                }
            }

            $count++;
            $max = max($max, $count);
            $index++;
        }

        return min($max + $remain, $length);
    }
}

$solution = new Solution();
var_dump($solution->longestOnes([1,1,1,0], 0));
var_dump($solution->longestOnes([1,1,1,0,0,0,1,1,1,1,0], 2));
var_dump($solution->longestOnes([1,1,1,0], 2));
var_dump($solution->longestOnes([0,1,1,1,0], 2));
var_dump($solution->longestOnes([0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], 3));
