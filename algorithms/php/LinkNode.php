<?php
class LinkNode {
    public $value;
    public $next;
    public function __construct($x) {
        $this->value = $x;
        $this->next = null;
    }

    public function getSize() {
        $size = 1;
        $next = $this->next;
        while ($next) {
            $size++;
            $next = $next->next;
        }

        return $size;
    }

    public function getNumber($reverse = true) {
        $index = $reverse ? $this->getSize() - 1 : 0;
        $step = $reverse ? -1 : 1;
        $number = $this->value * pow(10, $index);
        $next = $this->next;
        while ($next) {
            $index = $index + $step;
            $number += $next->value * pow(10, $index);
            $next = $next->next;
        }

        return $number;
    }

    public function __toString() {
        $values = array($this->value);
        $next = $this->next;
        while ($next) {
            $values[] = $next->value;
            $next = $next->next;
        }

        return implode(' -> ', $values);
    }
}