class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = 0
        if len(nums) == 0:
            return length
        for i in range(0, len(nums)):
            if (nums[length] != nums[i]):
                length += 1
                nums[length] = nums[i]
        return length + 1