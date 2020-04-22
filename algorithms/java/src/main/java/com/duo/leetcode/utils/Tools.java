package com.duo.leetcode.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Tools {
    public static String toString(int[] v) {
        return "[" + String.join(",", Arrays.stream(v).mapToObj(String::valueOf).toArray(String[]::new)) + "]";
    }

    public static String toString(int[][] vv) {
        ArrayList<String> s = new ArrayList<String>();
        for (int[] v : vv) {
            s.add(Tools.toString(v));
        }
        return "[" + String.join(",", s) + "]";
    }

    public static String toString(char[] v) {
        return "[" + new String(v) + "]";
    }

    public static String toString(char[][] vv) {
        ArrayList<String> s = new ArrayList<String>();
        for (char[] v : vv) {
            s.add(Tools.toString(v));
        }
        return "[" + String.join(",", s) + "]";
    }
}