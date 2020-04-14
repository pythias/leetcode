package com.duo.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.duo.leetcode.Algorithm;

public class MiddleNode implements Algorithm {
    public ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode c = head;
        HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        while (true) {
            if (c == null) {
                break;
            }
            map.put(size, c);
            size++;
            c = c.next;
        }

        return map.get((int) Math.ceil(size / 2));
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            List<String> values = new ArrayList<String>();
            ListNode head = this;
            while (true) {
                if (head == null) {
                    break;
                }

                values.add(head.val + "");
                head = head.next;
            }

            return String.join(", ", values);
        }
    }

    private ListNode _createNode(int[] values) {
        ListNode head = null;
        ListNode current = null;
        for (int i : values) {
            if (head == null) {
                head = new ListNode(i);
                current = head;
            } else {
                current.next = new ListNode(i);
                current = current.next;
            }
        }

        return head;
    }

    private void _run(int[] values) {
        ListNode middleNode = this.middleNode(this._createNode(values));
        System.out.printf("Middle node of [%s] is [%s]\n", String.join(", ", Arrays.stream(values).mapToObj(String::valueOf).toArray(String[]::new)), middleNode.toString());
    }

    @Override
    public void run() {
        this._run(new int[] { 1, 2, 3, 4, 5});
        this._run(new int[] { 1, 2, 3, 4 });
    }
}
