# 原始思路
class MinStack1:
    def __init__(self):
        # 记录栈中的所有元素
        self.stk = []
        # 阶段性记录栈中的最小元素
        self.minStk = []

    def push(self, val: int) -> None:
        self.stk.append(val)
        # 维护 minStk 栈顶为全栈最小元素
        if not self.minStk or val <= self.minStk[-1]:
            # 新插入的这个元素就是全栈最小的
            self.minStk.append(val)
        else:
            # 插入的这个元素比较大
            self.minStk.append(self.minStk[-1])

    def pop(self) -> None:
        self.stk.pop()
        self.minStk.pop()

    def top(self) -> int:
        return self.stk[-1]

    def getMin(self) -> int:
        # minStk 栈顶为全栈最小元素
        return self.minStk[-1]

# 优化版
class MinStack:
    def __init__(self):
        # 记录栈中的所有元素
        self.stk = []
        # 阶段性记录栈中的最小元素
        self.minStk = []

    def push(self, val: int) -> None:
        self.stk.append(val)
        # 维护 minStk 栈顶为全栈最小元素
        if not self.minStk or val <= self.minStk[-1]:
            # 新插入的这个元素就是全栈最小的
            self.minStk.append(val)

    def pop(self) -> None:
        # 注意 Java 的语言特性，比较 Integer 相等要用 equals 方法
        if self.stk[-1] == self.minStk[-1]:
            # 弹出的元素是全栈最小的
            self.minStk.pop()
        self.stk.pop()

    def top(self) -> int:
        return self.stk[-1]

    def getMin(self) -> int:
        # minStk 栈顶为全栈最小元素
        return self.minStk[-1]