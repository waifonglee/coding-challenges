class Solution:
    # 3 cases: max = 
    # current * minSoFar -> current is negative
    # current * maxSoFar -> current is positive
    # current -> current is the start of the largest subarray, 
    #               when max so far is negative and current is positive
    # When current is 0, it breaks the array and will use a new element as start as 0 * anything is 0
    def maxProduct(self, nums: List[int]) -> int:
        maxSoFar = nums[0] # max that ends with previous element
        minSoFar = nums[0] # min that ends with prev element
        maxAll = nums[0] #global max
        
        for i in range(1, len(nums)) :
            current = nums[i]
            maxSoFarNow = maxSoFar
            maxSoFar = max(current * minSoFar, current * maxSoFar, current)
            minSoFar = min(current * minSoFar, current * maxSoFarNow, current)
            maxAll = max(maxAll, maxSoFar)
            
        return maxAll

