package com.duo.leetcode._1300._1352;

import com.duo.leetcode.Algorithm;

import java.util.ArrayList;

public class ProductOfNumbers1 implements Algorithm {
    private ArrayList<Integer> products;
    private int lastZeroAt;
    private int size;
    private int lastNumber;
    public ProductOfNumbers1() {
        this.products = new ArrayList<Integer>();
        this.lastNumber = 0;
        this.size = 0;
        this.lastZeroAt = -1;
    }

    public void add(int num) {
        this.lastNumber = num;
        this.size++;
        if (num == 0) {
            this.lastZeroAt = this.size;
            this.products.add(1);
        } else {
            if (this.size == 1) {
                this.products.add(num);
            } else {
                this.products.add(this.products.get(this.size - 2) * num);
            }
        }
    }

    public int getProduct(int k) {
        if (k > (this.size - this.lastZeroAt)) {
            return 0;
        }

        if (k == 1) {
            return this.lastNumber;
        }

        return this.products.get(this.size - 1) / this.products.get(this.size - 1 - k);
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
