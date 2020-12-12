class Solution:
    #reset new subarray when maxSoFar reaches negative
    def maxSubArray(self, nums: List[int]) -> int:
        maxSoFar = nums[0]
        globalMax = nums[0]
        
        for i in range(1, len(nums)) :
            current = nums[i]
            if maxSoFar <= 0:
                maxSoFar = current
            else:
                maxSoFar += current
            
            globalMax = max(globalMax, maxSoFar)
            
        return globalMax
        