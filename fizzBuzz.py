#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def fizzBuzz(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        a = []

        for i in range(1, n + 1):
            if i % 15 == 0:
                a.append('FizzBuzz')
                continue

            if i % 3 == 0:
                a.append('Fizz')
                continue

            if i % 5 == 0:
                a.append('Buzz')
                continue

            a.append('%d' % i)

        return a

if __name__ == "__main__":
    s = Solution()
    print s.fizzBuzz(5)
    print s.fizzBuzz(15)
    print s.fizzBuzz(20)