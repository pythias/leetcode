<?php
/**
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 * @author:pythias@gmail.com
 */

class Solution {
    public function maxArea($height) {
        $size = count($height);
        $left = 0;
        $right = $size - 1;
        $area = 0;
        $areaLeft  = 0;
        $areaRight = 0;

        while ($left < $right) {
            $tmpArea = min($height[$left], $height[$right]) * ($right - $left);
            if ($tmpArea > $area) {
                $area = $tmpArea;
                $areaLeft = $left;
                $areaRight = $right;
            }

            if ($height[$left] < $height[$right]) {
                $left++;
            } else {
                $right--;
            }
        }

        echo implode(",", $height) . " max area from:{$areaLeft}=>{$height[$areaLeft]}, to:{$areaRight}=>{$height[$areaRight]}, area:{$area}\r\n";
    }
}

$sol = new Solution();
$sol->maxArea(array(1, 2, 3, 4, 5));
$sol->maxArea(array(5, 4, 3, 2, 1));
$sol->maxArea(array(5, 4, 3, 2, 0, 0, 1));
$sol->maxArea(array(5, 4, 0, 0, 3, 2, 1));