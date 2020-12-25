class Solution {
    /*
    You are a professional robber planning to rob houses along a street. Each house has a certain amount
    of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses
    have security system connected and it will automatically contact the police if two adjacent houses
    were broken into on the same night.
    
    Given a list of non-negative integers representing the amount of money of each house, determine the
    maximum amount of money you can rob tonight without alerting the police.
    
    2 cases:
    memo[i] = max value until house i. rob or not
    
    1. if i dont rob the i th house, memo[i] = memo[i - 1]
    2. if i rob the i th house, memo[i] = val(i) + memo[i - 2] 
    why we dont care about value of memo[i-1] in case 2? since its the max of whether we rob or not.
    because if not robbing i - 1 is more lucrative than robbing it, i-1 will have the value of memo[i-2]
    also. if robbing is more lucrative, it is taken care of in case 1 
    um draw out if still dont understand :D
    
    memo[i] = max (rob, dont rob)
    
    */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int prev = nums[0]; // i - 2
        int curr = Math.max(nums[1], prev); // i - 1
        
        for (int i = 2; i < nums.length; i ++) {
            int temp = curr;
            curr = Math.max(curr, prev + nums[i]);
            prev = temp;
        }
        
        return curr;
    }
}