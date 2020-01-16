
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = null;
        ListNode c = head;
        boolean d = false;
        while (true) {
            if (c == null) {
                if (d) {
                    p = null;
                }

                break;
            }

            if (c.next == null) {
                if (d) {
                    if (p == null || p == c) {
                        head = null;
                    } else {
                        p.next = null;
                    }
                }

                break;
            }

            if (c.val == c.next.val) {
                d = true;
                c.next = c.next.next;
            } else {
                if (d) {
                    if (p == null) {
                        head = c.next;
                        c = head;
                    } else {
                        c = c.next;
                        p.next = c;
                    }
                } else {
                    if (p == null) {
                        p = c;
                    } else {
                        p = p.next;
                    }

                    c = c.next;
                }
                d = false;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.deleteDuplicates(createNode(new int[] { 1, 4, 4, 4, 7, 11, 11, 11, 15, 15 })));
        print(solution.deleteDuplicates(createNode(new int[] { 1, 1 })));
        print(solution.deleteDuplicates(createNode(new int[] { 1, 1, 2, 2 })));
        print(solution.deleteDuplicates(createNode(new int[] { 1, 1, 3, 4, 5, 5 })));
        print(solution.deleteDuplicates(createNode(new int[] { 2, 3, 4, 5 })));
    }

    private static ListNode createNode(int[] values) {
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

    private static void print(ListNode node) {
        StringBuilder sb = new StringBuilder();
        ListNode head = node;
        while (true) {
            if (head == null) {
                break;
            }

            sb.append(head.val);
            sb.append(" ");
            head = head.next;
        }

        System.out.println(sb.toString());
    }
}