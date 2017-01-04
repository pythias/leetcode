#!/usr/bin/env bash

awk '{
    for (i = 1; i <= NF; i++) {
        values[FNR, i] = $i
    }
} END {
    for (i = 1; i <= NF; i++) {
        line = ""
        sep = ""
        for (j = 1; j <= FNR; j++) {
            line = sprintf("%s%s%s", line, sep, values[j, i])
            sep = " "
        }
        print line
    }
}' file.txt