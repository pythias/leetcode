#!/usr/bin/env bash

awk '{
    if (FNR == 10) {
        print $0
    }
}' file.txt