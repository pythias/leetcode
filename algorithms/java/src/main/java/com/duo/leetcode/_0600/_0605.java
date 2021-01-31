package com.duo.leetcode._0600;

import java.util.Arrays;

public class _0605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        int length = flowerbed.length;
        if (n > length) {
            return false;
        }

        if (length == 1) {
            return flowerbed[0] == 0;
        }

        for (int i = 0; i < length; i++) {
            int v = flowerbed[i];
            if (v == 1) {
                if (i < (length - 1)) {
                    flowerbed[i+1] = -1;
                }
                continue;
            }

            if (v == -1) {
                continue;
            }

            if (i > 0 && flowerbed[i-1] != 1) {
                if (i == (length - 1)) {
                    return n-- == 1;
                }
            }

            if (flowerbed[i+1] != 1) {
                flowerbed[i] = 1;
                flowerbed[i+1] = -1;

                if (n-- == 1) {
                    return true;
                }
            }            
        }

        return false;
    }
}
