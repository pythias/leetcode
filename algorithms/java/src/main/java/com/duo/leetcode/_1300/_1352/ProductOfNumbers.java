package com.duo.leetcode._1300._1352;

import com.duo.leetcode.Algorithm;

import java.util.ArrayList;

public class ProductOfNumbers implements Algorithm {
    private ArrayList<Integer> numbers;
    private int lastZeroAt;
    private int size;
    public ProductOfNumbers() {
        this.numbers = new ArrayList<Integer>();
        this.lastZeroAt = -1;
        this.size = 0;
    }

    public void add(int num) {
        this.numbers.add(num);
        this.size++;
        if (num == 0) {
            this.lastZeroAt = this.size;
        }
    }

    public int getProduct(int k) {
        if (this.lastZeroAt > -1 && k > (this.size - this.lastZeroAt)) {
            return 0;
        }

        int value = 1;
        for (int i = 1; i <= k; i++) {
            value *= this.numbers.get(this.size - i);
        }

        return value;
    }

    public void run() {
        this.add(3);
        this.add(0);
        this.add(2);
        this.add(5);
        this.add(4);
        System.out.println(this.getProduct(2));
        System.out.println(this.getProduct(3));
        System.out.println(this.getProduct(4));
    }
}
