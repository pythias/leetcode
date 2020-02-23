package com.duo.leetcode;

import com.duo.leetcode._0100._146.LRUCache;
import org.junit.Assert;
import org.junit.Test;

public class TestLRU {
    @Test
    public void test0() {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(1, 1);
        Assert.assertEquals(1, lruCache.get(1));
        Assert.assertEquals(-1, lruCache.get(2));

        lruCache.put(1, 2);
        Assert.assertEquals(2, lruCache.get(1));
        Assert.assertEquals(-1, lruCache.get(2));

        lruCache.put(2, 3);
        Assert.assertEquals(-1, lruCache.get(1));
        Assert.assertEquals(3, lruCache.get(2));
    }

    @Test
    public void test1() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(2, 2);
        Assert.assertEquals(2, lruCache.get(2));
        lruCache.put(1, 1);
        lruCache.put(4, 1);
        Assert.assertEquals(-1, lruCache.get(2));
    }
}
