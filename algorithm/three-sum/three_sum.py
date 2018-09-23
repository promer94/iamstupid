def three_sum(nums):
    """
    :type nums: List[int]
    :rtype: List[List[int]]
    """
    nums.sort()
    start = 0
    result = []
    while (start < len(nums)) and (nums[start] <= 0):
        low = start + 1
        high = len(nums) - 1
        while(low < high):
            sum = nums[start] + nums[low] + nums[high]
            if(sum > 0):
                high -= 1
                continue
            if(sum < 0):
                low += 1
                continue
            result.insert(-1,[nums[start], nums[low], nums[high]])
            while(low +1 <len(nums)) and (nums[low] == nums[low +1] ):
                low +=1
            low += 1
        while(start+1<len(nums)) and (nums[start] == nums[start +1]):
            start +=1
        start += 1
    return result  
         