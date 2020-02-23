package com.duo.leetcode._0100._146;

import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {
    private int capacity;
    private int size;
    private HashMap<Integer, Integer> cache;
    private ArrayList<Integer> lurs;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<Integer, Integer>();
        this.size = 0;
        this.lurs = new ArrayList<Integer>();
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            this.renew(key);
            return this.cache.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if (this.size == this.capacity) {
            if (!this.cache.containsKey(key)) {
                int oldKey = this.lurs.remove(0);
                this.cache.remove(oldKey);
                this.lurs.add(key);
            } else {
                this.renew(key);
            }
        } else {
            if (!this.cache.containsKey(key)) {
                this.size++;
                this.lurs.add(key);
            } else {
                this.renew(key);
            }
        }

        this.cache.put(key, value);
    }

    private void renew(int key) {
        for (int i = 0; i < this.lurs.size(); i++) {
            if (this.lurs.get(i) == key) {
                this.lurs.remove(i);
                break;
            }
        }
        this.lurs.add(key);
    }
}
