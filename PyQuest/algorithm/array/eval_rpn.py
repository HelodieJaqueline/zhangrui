class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stk = []
        for token in tokens:
            if token in "+-*/":
                # 是个运算符，从栈顶拿出两个数字进行运算，运算结果入栈
                a = stk.pop()
                b = stk.pop()
                if token == "+":
                    stk.append(a + b)
                elif token == "*":
                    stk.append(a * b)
                # 对于减法和除法，顺序别搞反了，第二个数是被除（减）数
                elif token == "-":
                    stk.append(b - a)
                elif token == "/":
                    stk.append(int(b / a))  # Ensure the result is an integer
            else:
                # 是个数字，直接入栈即可
                stk.append(int(token))
        # 最后栈中剩下一个数字，即是计算结果
        return stk.pop()