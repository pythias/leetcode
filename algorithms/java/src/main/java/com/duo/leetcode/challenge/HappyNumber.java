package com.duo.leetcode.challenge;

import com.duo.leetcode.Algorithm;

public class HappyNumber implements Algorithm {
    public boolean isHappy(int n) {
        if (n < 5) {
            return n == 1;
        }

        int m = 0;
        for (int i = 0; i < 11; i++) {
            int p = (int) Math.pow(10, i);
            if (p > n) {
                break;
            }

            int r = (n / p) % 10;
            m += r * r;
        }

        return this.isHappy(m);
    }

    @Override
    public void run() {
        System.out.println(this.isHappy(1));
        System.out.println(this.isHappy(2147483647));
        System.out.println(this.isHappy(19));
        System.out.println(this.isHappy(88));
    }
}
