package com.duo.leetcode.challenge;

import com.duo.leetcode.Algorithm;
import com.duo.leetcode.utils.Tools;

public class NumIslands implements Algorithm {
    private char[][] grid;

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        this.grid = grid;

        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char c = grid[i][j];
                if (c == '0') {
                    continue;
                }

                islands++;
                dfs(i, j);
            }
        }

        return islands;
    }

    private void dfs(int i, int j) {
        if (i < 0 || j < 0 || (i + 1) > grid.length || (j + 1) > grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(i - 1, j);
        dfs(i, j - 1);
        dfs(i + 1, j);
        dfs(i, j + 1);
    }

    private void _run(char[][] grid) {
        System.out.printf("Number of Islands of %s is %d\n", Tools.toString(grid), this.numIslands(grid));
    }

    @Override
    public void run() {
        this._run(new char[][]{{'1', '0', '1'}});
        this._run(new char[][]{{'1', '0', '1'}, {'0', '0', '1'}, {'1', '1', '1'}});
        this._run(new char[][]{{'0', '0', '1'}, {'0', '0', '1'}, {'1', '1', '1'}});
        this._run(new char[][]{{'1', '1', '1'}, {'0', '0', '1'}, {'1', '1', '1'}});
        this._run(new char[][]{{'1', '1', '1'}, {'0', '0', '0'}, {'1', '1', '1'}});
    }
}