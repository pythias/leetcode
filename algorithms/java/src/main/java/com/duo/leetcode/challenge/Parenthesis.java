package com.duo.leetcode.challenge;

import com.duo.leetcode.Algorithm;

public class Parenthesis implements Algorithm {
    public boolean checkValidString(String s) {
        int size = s.length();
        if (size == 0) {
            return true;
        }

        int min = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                min++;
            } else {
                min--;
            }

            if (c != ')') {
                max++;
            } else {
                max--;
            }

            if (max < 0) {
                return false;
            }

            min = Math.max(min, 0);
        }

        return min == 0;
    }

    private void _run(String s) {
        System.out.printf("Valid Parenthesis String of %s is %b\n", s, this.checkValidString(s));
    }

    @Override
    public void run() {
        this._run("((()))()(())(*()()())**(())()()()()((*()*))((*()*)");
        this._run(")(");
        this._run("()");
        this._run("())");
        this._run("(*)");
        this._run("(*))");
        this._run("((*)");
        this._run("((*))");
        this._run("((*)))");
    }
}