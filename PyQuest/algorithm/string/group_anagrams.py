class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # 编码到分组的映射
        codeToGroup = {}
        for s in strs:
            # 对字符串进行编码
            code = self.encode(s)
            # 把编码相同的字符串放在一起
            if code not in codeToGroup:
                codeToGroup[code] = []
            codeToGroup[code].append(s)

        # 获取结果
        res = []
        for group in codeToGroup.values():
            res.append(group)

        return res

    # 利用每个字符的出现次数进行编码
    def encode(self, s: str) -> str:
        count = [0] * 26
        for c in s:
            delta = ord(c) - ord('a')
            count[delta] += 1
        return ''.join(map(chr, count))