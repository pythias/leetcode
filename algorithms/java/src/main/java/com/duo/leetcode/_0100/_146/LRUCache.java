package com.duo.leetcode._0100._146;

import java.util.HashMap;

public class LRUCache {
    static class ValueNode {
        private ValueNode prev;
        private ValueNode next;
        private int key;
        private int value;

        public ValueNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public ValueNode() {

        }
    }

    private int capacity;
    private HashMap<Integer, ValueNode> cache;
    private ValueNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<Integer, ValueNode>();
        this.head = new ValueNode();
        this.tail = new ValueNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            ValueNode valueNode = this.cache.get(key);
            this.moveToHead(valueNode);
            return valueNode.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            ValueNode valueNode = this.cache.get(key);
            valueNode.value = value;
            this.moveToHead(valueNode);
            return;
        }

        ValueNode valueNode = new ValueNode(key, value);
        this.cache.put(key, valueNode);
        this.newNode(valueNode);

        if (this.cache.size() > this.capacity) {
            this.removeTail();
        }
    }

    private void moveToHead(ValueNode node) {
        this.removeNode(node);
        this.newNode(node);
    }

    private void newNode(ValueNode node) {
        node.next = this.head.next;
        node.prev = this.head;

        this.head.next.prev = node;
        this.head.next = node;
    }

    private void removeNode(ValueNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void removeTail() {
        ValueNode node = this.tail.prev;
        this.removeNode(node);
        this.cache.remove(node.key);
    }
}
