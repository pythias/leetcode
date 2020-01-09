class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
                
        if n < 0:
            x = 1 / x
            n = 0 - n

        if n == 1:
            return x

        return self.half(x, n)
    
    def half(self, x: float, n: int) -> float:
        if n == 2:
            return x * x

        if n == 3:
            return x * x * x

        left = self.half(x, int(n / 2))
        if n % 2 == 0:
            return left * left
        else:
            return left * left * x

if __name__ == "__main__":
    s = Solution()
    print(s.myPow(2.0, 10))
    print(s.myPow(2.1, 3))
    print(s.myPow(2, -2))
    print(s.myPow(2, -3))