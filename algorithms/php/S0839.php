<?php
/**
 * 相似字符串，然后分组（前几次提交的代码都忘记分组的事情了）
 * @link https://leetcode.com/problems/similar-string-groups
 */
class S0839 {
    /**
     * @param String[] $strs
     * @return Integer
     */
    public function numSimilarGroups($strs) {
        $count = count($strs);
        $groups = array_fill(0, $count, -1);
        for ($i = 0; $i < $count; $i++) { 
            for ($j = $i + 1; $j < $count; $j++) { 
                if ($this->_isSimilar($strs[$i], $strs[$j])) {
                    if ($groups[$i] == -1 && $groups[$j] == -1) {
                        $groups[$i] = $i;
                        $groups[$j] = $i;
                        continue;
                    }
                    
                    if ($groups[$i] == -1) {
                        if ($groups[$j] != -1) {
                            $groups[$i] = $groups[$j];
                        } else {
                            $groups[$i] = $i;
                        }
                    } else if ($groups[$j] == -1) {
                        $groups[$j] = $groups[$i];
                    } else {
                        $this->_merge($groups, $groups[$j], $groups[$i]);
                    }
                }
            }
        }

        $value = 0;
        foreach ($groups as $k => $v) {
            if ($groups[$k] == $k || $groups[$k] == -1) {
                $value++;
            }
        }

        return $value;
    }

    private function _merge(&$groups, $from, $to) {
        foreach ($groups as $k => $v) {
            if ($v == $from) {
                $groups[$k] = $to;
            }
        }
    }

    private function _isSimilar($left, $right) {
        $count = 0;
        for ($i = 0; $i < strlen($left); $i++) { 
            if ($left[$i] == $right[$i]) {
                continue;
            }

            $count++;
        }

        return $count == 2 || $count == 0;
    }
}

$solution = new S0839();
echo $solution->numSimilarGroups(["zkhnmefhyr", "ykznfhehmr", "mkhnyefrzh", "zkhnyefrmh", "zkmnhefhyr", "ykznhfehmr", "zkynhfehmr", "mkhnhefrzy", "zkhnmefryh", "zkmnhfehyr"]) . PHP_EOL;
echo $solution->numSimilarGroups(['1234', '1234']) . PHP_EOL;
echo $solution->numSimilarGroups(["kccomwcgcs", "socgcmcwkc", "sgckwcmcoc", "coswcmcgkc", "cowkccmsgc", "cosgmccwkc", "sgmkwcccoc", "coswmccgkc", "kowcccmsgc", "kgcomwcccs"]) . PHP_EOL;
echo $solution->numSimilarGroups(["ajdidocuyh", "djdyaohuic", "ddjyhuicoa", "djdhaoyuic", "ddjoiuycha", "ddhoiuycja", "ajdydocuih", "ddjiouycha", "ajdydohuic", "ddjyouicha"]) . PHP_EOL;
echo $solution->numSimilarGroups(["tars", "rats", "arts", "star"]) . PHP_EOL;

