class Solution:
    # 备忘录
    def __init__(self):
        self.memo = [0] * 1000

    def climbStairs(self, n: int) -> int:
        return self.dp(n)

    # 定义：爬到第 n 级台阶的方法个数为 dp(n)
    def dp(self, n: int) -> int:
        # base case
        if n <= 2:
            return n
        if self.memo[n] > 0:
            return self.memo[n]
        # 状态转移方程：
        # 爬到第 n 级台阶的方法个数等于爬到 n - 1 的方法个数和爬到 n - 2 的方法个数之和。
        self.memo[n] = self.dp(n - 1) + self.dp(n - 2)
        return self.memo[n]