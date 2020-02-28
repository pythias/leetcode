package com.duo.leetcode._0800._821;

public class ShortestToChar {
    public int[] shortestToChar(String S, char C) {
        int[] shortest = new int[S.length()];
        int from = 0;
        while (true) {
            int index = S.indexOf(C, from);
            for (int j = from; j <= index; j++) {
                if (from == 0) {
                    shortest[j] = index - j;
                } else {
                    shortest[j] = Math.min(index - j, j - from + 1);
                }
            }

            if (index == -1) {
                for (int j = from; j < S.length(); j++) {
                    shortest[j] = j - from + 1;
                }
                break;
            }

            from = index + 1;
        }

        return shortest;
    }
}
