#!/bin/bash
sed 's/ /\n/g' words.txt | awk '{if ($1 != "") {counts[$1]++}} END {for (w in counts) {print w " " counts[w]}}'|sort -nrk2