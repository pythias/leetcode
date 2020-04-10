package com.duo.leetcode.challenge;

import java.util.ArrayList;

import com.duo.leetcode.Algorithm;

public class MinStack implements Algorithm {
    private ArrayList<Integer> values;
    private ArrayList<Integer> mins;
    private int min = Integer.MAX_VALUE;
    private int last;

    /** initialize your data structure here. */
    public MinStack() {
        this.values = new ArrayList<Integer>();
        this.mins = new ArrayList<Integer>();
        this.last = 0;
    }

    public void push(int x) {
        this.values.add(x);
        this.last++;
        
        this.min = Math.min(this.min, x);
        this.mins.add(this.min);
    }

    public void pop() {
        if (this.last == 0) {
            return;
        }

        this.values.remove(this.last - 1);
        this.mins.remove(this.last - 1);
        this.last--;

        if (this.last > 0) {
            this.min = this.mins.get(this.last - 1);
        } else {
            this.min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        if (this.last == 0) {
            return 0;
        }

        return this.values.get(this.last - 1);
    }

    public int getMin() {
        if (this.last == 0) {
            return 0;
        }

        return this.min;
    }

    @Override
    public void run() {
        this.push(1);
        this.push(-2);
        this.push(3);

        System.out.println(this.getMin());
        System.out.println(this.top());
        this.pop();
        System.out.println(this.getMin());
        System.out.println(this.top());
        this.pop();
        System.out.println(this.getMin());
        System.out.println(this.top());
    }
}