package com.duo.leetcode._0500._520;

import com.duo.leetcode.Algorithm;

public class DetectCapital implements Algorithm {
    public boolean detectCapitalUse(String word) {
        int u = 0;
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isUpperCase(c)) {
                u++;
            }
        }

        return Character.isUpperCase(word.charAt(0)) ? (u == 0 || u == word.length() - 1) : u == 0;
    }

    public void run() {
        System.out.println(this.detectCapitalUse("CHN"));
        System.out.println(this.detectCapitalUse("Leetcode"));
        System.out.println(this.detectCapitalUse("wOrd"));
    }
}
