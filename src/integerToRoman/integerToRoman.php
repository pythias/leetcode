<?php
/**
 *
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author:pythias@gmail.com
 */

class Solution {
    private $_romanNumerals = array(
        1000 => 'M',
        500 => 'D',
        100 => 'C',
        50 => 'L',
        10 => 'X',
        5 => 'V',
        1 => 'I',
    );

    private $_romanValues = array(
        'I' => 1,
        'V' => 5,
        'X' => 10,
        'L' => 50,
        'C' => 100,
        'D' => 500,
        'M' => 1000,
    );

    private function _getPrevRoman($num) {
        $romanPrev = 'M';
        foreach ($this->_romanNumerals as $key => $value) {
            if ($num == $key) {
                return $romanPrev;
            }

            $romanPrev = $value;
        }

        return -1;
    }

    public function intToRoman($num) {
        $roman = '';
        $numRemain = $num;
        $numLast = 0;
        $count = 1;
        while ($numRemain > 0) {
            foreach ($this->_romanNumerals as $key => $value) {
                if ($numRemain >= $key) {
                    if ($numLast == $key) {
                        $count++;
                    } else {
                        $count = 1;
                    }

                    $numRemain -= $key;
                    $numLast = $key;

                    if ($count == 4) {
                        $roman = substr($roman, 0, strlen($roman) - 3);
                        $romanPrev = $this->_getPrevRoman($numLast);
                        if ($romanPrev == $roman[strlen($roman) - 1]) {
                            $romanPrev = $this->_getPrevRoman($this->_romanValues[$romanPrev]);
                            $roman = substr($roman, 0, strlen($roman) - 1);
                        }

                        $roman .= $value . $romanPrev;
                    } else {
                        $roman .= $value;
                    }
                    
                    break;
                }
            }
        }

        echo "number:{$num}, roman:{$roman}\r\n";
    }
}

$sol = new Solution();
$sol->intToRoman(3);
$sol->intToRoman(38);
$sol->intToRoman(84);
$sol->intToRoman(1890);