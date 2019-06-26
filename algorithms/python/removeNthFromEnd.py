"""
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
"""

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

    def __str__(self):
        if self.next:
            return "%d -> %s" % (self.val, self.next)
        else:
            return "%d" % self.val

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        list0 = head
        list1 = head
        list2 = head

        for x in xrange(0, n):
            if list1 == None:
                return head

            list1 = list1.next

        while list1:
            list0 = list2
            list1 = list1.next
            list2 = list2.next

        if list0.next == list2.next:
            head = list0.next
        else:
            list0.next = list2.next

        return head


def createList():
    node1 = ListNode(x=1)
    node2 = ListNode(x=2)
    node3 = ListNode(x=3)
    node4 = ListNode(x=4)
    node5 = ListNode(x=5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    return node1

if __name__ == "__main__":
    s = Solution()
    head = createList()
    print "%s" % s.removeNthFromEnd(head, 2)

    s = Solution()
    head = createList()
    print "%s" % s.removeNthFromEnd(head, 5)

    s = Solution()
    head = createList()
    print "%s" % s.removeNthFromEnd(head, 6)

