class Solution:
    def simplifyPath(self, path: str) -> str:
        parts = path.split("/")
        stk = []
        # 借助栈计算最终的文件夹路径
        for part in parts:
            if part == "" or part == ".":
                continue
            if part == "..":
                if stk:
                    stk.pop()
                continue
            stk.append(part)
        # 栈中存储的文件夹组成路径
        res = ""
        while stk:
            res = "/" + stk.pop() + res
        return res if res else "/"
