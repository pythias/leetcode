package com.duo.leetcode.challenge;

import com.duo.leetcode.Algorithm;

import java.util.*;

public class GroupAnagrams implements Algorithm {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String seq = new String(cs);

            if (m.containsKey(seq)) {
                m.get(seq).add(s);
            } else {
                ArrayList<String> t = new ArrayList<>();
                t.add(s);
                m.put(seq, t);
            }
        }

        return new ArrayList<>(m.values());
    }

    @Override
    public void run() {
        System.out.println(this.groupAnagrams(new String[] {"abc", "acb", "bca", "abd", "dba", "dbc"}));
    }
}
