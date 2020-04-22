package com.duo.leetcode.challenge;

import com.duo.leetcode.Algorithm;
import com.duo.leetcode.utils.Tools;

public class MinPathSum implements Algorithm {
    public int minPathSum(int[][] grid) {
        return 0;
    }

    private void _run(int[][] grid) {
        System.out.printf("Minimum Path Sum of %s is %d\n", Tools.toString(grid), this.minPathSum(grid));
    }

    @Override
    public void run() {
        this._run(new int[][] { { 1, 0, 1 }, { 0, 0, 1 }, { 1, 1, 1 } });
    }
}