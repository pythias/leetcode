<?php
/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * @author:pythias@gmail.com
 */

class Solution {
    public function findMedianSortedArrays($a, $b) {
        $median = 0;
        $lenA = count($a);
        $lenB = count($b);
        $needDivide = (($lenA + $lenB) % 2) == 0;
        $offsetM = ($lenA + $lenB) / 2 - ($needDivide ? 1 : 0);
        $offsetA = 0;
        $offsetB = 0;

        while (true) {
            if ($a[$offsetA] < $b[$offsetB]) {
                if ($offsetA < $lenA - 1)  {
                    $offsetA++;
                } else if ($offsetB < $lenB - 1) {
                    $offsetB++;
                }
            } else {
                if ($offsetB < $lenB - 1) {
                    $offsetB++;
                } else if ($offsetA < $lenA - 1) {
                    $offsetA++;
                }
            }

            if ($offsetA + $offsetB >= $offsetM) break;
        }

        if ($needDivide) {
            $median = ($a[$offsetA] + $b[$offsetB]) / 2;
        } else {
            if ($offsetA > $offsetB) {
                $median = $a[$offsetA - 1];
            } else {
                $median = $b[$offsetB - 1];
            }
        }

        echo "median={$median}\r\n";
    }
}

$sol = new Solution();
$sol->findMedianSortedArrays(array(1), array(2));
$sol->findMedianSortedArrays(array(1, 3, 5), array(2, 4));
$sol->findMedianSortedArrays(array(1, 3, 12, 14, 16), array(8, 10, 11, 13));
