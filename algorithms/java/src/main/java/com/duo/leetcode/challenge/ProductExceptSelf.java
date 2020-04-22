package com.duo.leetcode.challenge;

import com.duo.leetcode.Algorithm;
import com.duo.leetcode.utils.Tools;

public class ProductExceptSelf implements Algorithm {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            p = p * num;
        }
        return products;
    }

    private void _run(int[] nums) {
        System.out.printf("ProductExceptSelf of %s is %s\n", Tools.toString(nums), 
                Tools.toString(this.productExceptSelf(nums)));
    }

    @Override
    public void run() {
        this._run(new int[] { 3, 7, 8 });
    }
}