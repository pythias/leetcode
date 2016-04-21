<?php
/**
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * @author:pythias@gmail.com
 */

class Solution {
    public function convert($s, $nRows) {
        $index = 0;
        $col = 0;
        $row = 0;
        $arrays = array();
        $length = strlen($s);

        while (true) {
            $zCol = ($col == 0 || $col % ($nRows - 1) == 0);
            if ($zCol == false) {
                $row = ($row == 0 ? ($nRows - 2) : ($row - 1));
            }

            $arrays[$row][$col] = $s[$index++];
            if ($index >= $length) break;
            
            if ($zCol) {
                if ($row + 1 == $nRows) { 
                    $col++;
                    $row = 0;
                } else {
                    $row++;
                }
            } else {
                $col++;
                if ($row + 1 == $nRows || $row == 1) { 
                    $row = 0;
                }
            }
        }

        $zigValue = '';
        for ($i = 0; $i < $nRows; $i++) { 
            for ($j = 0; $j < $col + 1; $j++) { 
                if (isset($arrays[$i][$j])) {
                    $zigValue .= $arrays[$i][$j];
                }
            }
        }
        
        echo "source string:'{$s}', rows:{$nRows}, zigzag string:'{$zigValue}'\r\n";
    }
}

$sol = new Solution();
$sol->convert("PAYPALISHIRING", 3); //PAHNAPLSIIGYIR
$sol->convert("PAYPALISHIRING", 4); //PINALSIGYAHRPI
$sol->convert("PAYPALISHIRING", 5); //PHASIYIRPLIGAN
