class Solution:
    #first missing positive must be in the range 1...n+1
    def firstMissingPositive(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 1
        
        nums.append(0) 
        #because its 0 indexed, we need space for the last number. i.e element 4 if length = 4
        
        #remove all nums out of range in 1... n + 1
        for i in range(0,len(nums)):
            if nums[i] >= len(nums) or nums[i] < 0: #len(nums) is now 1 more than len of original nums
                nums[i] = 0
        
        # use the index as hash for that particular number. i.e if nums[j] = x, nums[x] will be hash
        # for how many times x appears
        for j in range(0, len(nums)):
            value = nums[j] % len(nums) #value in nums[j] originally, we remove the num of times j appears
            nums[value] += len(nums)
            

        for k in range(1, len(nums)):
            if nums[k]//len(nums) == 0: #anything less than n / n = 0, hence if we nvr + n to the number in the prev loop, it means this does not exist
                return k
        
        return len(nums) #original num length + 1