class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        l = 0
        d = {}
        for x in s:
            if x in d:
                l += 2
                d.pop(x)
            else:
                d[x] = 1

        return l + int(len(d) > 0)

if __name__ == "__main__":
    s = Solution()
    print s.longestPalindrome('a')
    print s.longestPalindrome('aa')
    print s.longestPalindrome('aaa')
    print s.longestPalindrome('aaab')