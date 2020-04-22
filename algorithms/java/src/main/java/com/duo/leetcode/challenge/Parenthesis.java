package com.duo.leetcode.challenge;

import com.duo.leetcode.Algorithm;

public class Parenthesis implements Algorithm {
    public boolean checkValidString(String s) {
        return true;
    }

    private void _run(String s) {
        System.out.printf("Valid Parenthesis String of %s is %b\n", s, this.checkValidString(s));
    }

    @Override
    public void run() {
        this._run("(");
        this._run("())");
        this._run("(*)");
        this._run("(*))");
        this._run("((*)");
    }
}