package com.duo.leetcode.challenge;

import java.util.ArrayList;
import java.util.Stack;

import com.duo.leetcode.Algorithm;

public class BackspaceCompare implements Algorithm {
    public boolean backspaceCompare(String S, String T) {
        return this._backspace(S).equals(this._backspace(T));
    }

    private String _backspace1(String S) {
        ArrayList<String> stack = new ArrayList<>();
        int index = 0;
        for (char c : S.toCharArray()) {
            if (c == '#') {
                if (index > 0) {
                    stack.remove(index - 1);
                    index--;
                }
            } else {
                stack.add(Character.toString(c));
                index++;
            }
        }

        return String.join("", stack);
    }

    private String _backspace(String S) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : S.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        return stack.toString();
    }

    private void _run(String S, String T) {
        System.out.printf("Backspace Compare of %s and %s, backspace result are %s and %s, compare result is %b\n", S, T, this._backspace(S), this._backspace(T), this.backspaceCompare(S, T));
    }

    @Override
    public void run() {
        this._run("y#fo##f", "y#f#o##f");
        this._run("a#bc", "b#bc");
        this._run("a#b#c", "b#bc#");
        this._run("ab#c#", "abc##");
    }
}