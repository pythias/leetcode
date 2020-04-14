package com.duo.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;

import com.duo.leetcode.Algorithm;

public class StringShift implements Algorithm {
    public String stringShift(String s, int[][] shift) {
        int left = 0;
        int right = 0;
        for (int[] is : shift) {
            if (is[0] == 0) {
                left += is[1];
            } else {
                right += is[1];
            }
        }

        int m = (left - right) % s.length();
        if (m == 0) {
            return s;
        }

        if (m > 0) {
            return s.substring(m) + s.substring(0, m);
        }
        
        return s.substring(s.length() + m) + s.substring(0, s.length() + m);
    }

    private void _run(String s, int[][] shift) {
        System.out.printf("Perform String Shifts of %s and %s is %s\n",
            s, this.toString(shift),
            this.stringShift(s, shift));
    }

    private String toString(int[] v) {
        return "[" + String.join(",", Arrays.stream(v).mapToObj(String::valueOf).toArray(String[]::new)) + "]";
    }

    private String toString(int[][] vv) {
        ArrayList<String> s = new ArrayList<String>();
        for (int[] v : vv) {
            s.add(this.toString(v));
        }
        return "[" + String.join(",", s) + "]";
    }

    @Override
    public void run() {
        this._run("abc", new int[][] { { 0, 1 } });
        this._run("abc", new int[][] { { 0, 1 }, { 1, 2 } });
        this._run("abcdefg", new int[][] { { 1,1 }, { 1, 1 }, { 0, 2 }, { 1, 3 } });
    }
}