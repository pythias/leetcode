class Solution(object):
    def addStrings(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """

        cnum = {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}

        len1 = len(num1)
        len2 = len(num2)
        maxSize = max(len1, len2)
        nums = []
        plus = 0

        for i in range(1, maxSize + 1):
            s1 = '0' if i > len1 else num1[-i]
            s2 = '0' if i > len2 else num2[-i]
            n = cnum[s1] + cnum[s2] + plus
            if n > 9:
                nums.insert(0, '%d' % (n - 10))
                plus = 1
            else:
                nums.insert(0, '%d' % n)
                plus = 0

        if plus == 1:
            nums.insert(0, '1')

        return ''.join(nums)

if __name__ == "__main__":
    s = Solution()
    print s.addStrings('12', '1')
    print s.addStrings('987654321', '1234567890')
    print s.addStrings('99999', '10000001')