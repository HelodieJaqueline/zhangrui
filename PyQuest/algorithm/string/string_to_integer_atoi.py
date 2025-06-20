class Solution:
    def myAtoi(self, str: str) -> int:
        n = len(str)
        i = 0
        # 记录正负号
        sign = 1
        # 用 long 避免 int 溢出
        res = 0
        # 跳过前导空格
        while i < n and str[i] == ' ':
            i += 1
        if i == n:
            return 0

        # 记录符号位
        if i < n and str[i] == '-':
            sign = -1
            i += 1
        elif i < n and str[i] == '+':
            i += 1
        if i == n:
            return 0

        # 统计数字位
        while i < n and '0' <= str[i] <= '9':
            res = res * 10 + ord(str[i]) - ord('0')
            # 溢出判断
            if sign == 1 and res > 2**31 - 1:
                return 2**31 - 1
            if sign == -1 and res > 2**31:
                return -2**31
            i += 1

        # 如果溢出，强转成 int 就会和真实值不同
        return int(res) * sign