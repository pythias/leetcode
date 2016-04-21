<?php
/**
 *
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author:pythias@gmail.com
 */

class Solution {
    private $_romanValues = array(
        'I' => 1,
        'V' => 5,
        'X' => 10,
        'L' => 50,
        'C' => 100,
        'D' => 500,
        'M' => 1000,
    );

    public function romanToInt($s) {
        $value = 0;
        $len = strlen($s);
        $numLast = 0;
        for ($i = 0; $i < $len; $i++) { 
            $numTmp = $this->_romanValues[$s[$i]];
            if ($numTmp > $numLast && $numLast != 0) {
                $value -= $numLast * 2;
                $value += $numTmp;
            } else {
                $value += $numTmp;
            }

            $numLast = $numTmp;
        }

        echo "roman:{$s}, number:{$value}\r\n";
    }
}

$sol = new Solution();
$sol->romanToInt('III');
$sol->romanToInt('XXXVIII');
$sol->romanToInt('LXXXIV');
$sol->romanToInt('MDCCCXC');