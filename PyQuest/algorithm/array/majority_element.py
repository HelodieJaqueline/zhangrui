class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # 我们想寻找的那个众数
        target = 0
        # 计数器（类比带电粒子例子中的带电性）
        count = 0
        for i in range(len(nums)):
            if count == 0:
                # 当计数器为 0 时，假设 nums[i] 就是众数
                target = nums[i]
                # 众数出现了一次
                count = 1
            elif nums[i] == target:
                # 如果遇到的是目标众数，计数器累加
                count += 1
            else:
                # 如果遇到的不是目标众数，计数器递减
                count -= 1
        # 回想带电粒子的例子
        # 此时的 count 必然大于 0，此时的 target 必然就是目标众数
        return target