package com.duo.leetcode._0300._394;

import com.duo.leetcode.Algorithm;

public class DecodeString implements Algorithm {
    private int i = -1;
    private int length = -1;
    private char[] chars = null;

    public String decodeString(String s) {
        this.i = -1;
        this.length = s.length();
        this.chars = s.toCharArray();

        return this._decodeString().toString();
    }

    private StringBuilder _decodeString() {
        int size = 0;
        StringBuilder stringBuilder = new StringBuilder();

        while (++this.i < this.length) {
            char c = this.chars[this.i];
            if (c >= '0' && c <= '9') {
                size = size * 10 + (c - '0');
            } else if (c == '[') {
                StringBuilder tmp = this._decodeString();
                for (int j = 0; j < size; j++) {
                    stringBuilder.append(tmp.toString());
                }
                size = 0;
            } else if (c == ']') {
                return stringBuilder;
            } else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder;
    }

    public void run() {
        System.out.println(this.decodeString("100[leetcode]"));
        System.out.println(this.decodeString("2[a]3[bc]"));
        System.out.println(this.decodeString("2[a3[bc]]"));
        System.out.println(this.decodeString("2[a2[3[b]c]]"));
        System.out.println(this.decodeString("abc2[a2[3[b]c]]"));
    }
}