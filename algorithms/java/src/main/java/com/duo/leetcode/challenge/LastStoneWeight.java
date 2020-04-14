package com.duo.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.duo.leetcode.Algorithm;

public class LastStoneWeight implements Algorithm {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) {
            return 0;
        }

        if (stones.length == 1) {
            return stones[0];
        }

        List<Integer> ss = new ArrayList<Integer>();
        for (int stone : stones) {
            ss.add(stone);
        }

        while (true) {
            Collections.sort(ss);
            if (ss.size() == 2) {
                return ss.get(1) - ss.get(0);
            }

            if (ss.size() == 0) {
                return 0;
            }

            if (ss.size() < 2) {
                return ss.get(0);
            }
            
            int size = ss.size();
            int first = ss.get(size - 1);
            int second = ss.get(size - 2);
            int diff = first - second;
            if (diff > 0) {
                ss.add(diff);
            }
            ss.remove(size - 1);
            ss.remove(size - 2);
        }
    }

    private void _run(int[] stones) {
        System.out.printf("LastStoneWeight of [%s] is %d\n",
                String.join(",", Arrays.stream(stones).mapToObj(String::valueOf).toArray(String[]::new)),
                this.lastStoneWeight(stones));
    }

    @Override
    public void run() {
        this._run(new int[] { 3, 7, 8 });
    }
}