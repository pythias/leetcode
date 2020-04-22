package com.duo.leetcode.challenge;

import com.duo.leetcode.Algorithm;
import com.duo.leetcode.utils.Tools;

public class RotatedSorted implements Algorithm {
    public int search(int[] nums, int target) {
        return 0;
    }

    private void _run(int[] nums, int target) {
        System.out.printf("Search %d in Rotated Sorted Array %s, result is %s\n", target, Tools.toString(nums),
                this.search(nums, target));
    }

    @Override
    public void run() {
        this._run(new int[] { 3, 7, 8 }, 1);
    }
}