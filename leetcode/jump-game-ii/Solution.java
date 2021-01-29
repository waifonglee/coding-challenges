class Solution {
    /*
    Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Your goal is to reach the last index in the minimum number of jumps.

    You can assume that you can always reach the last index.
    
    i used dp. 
    */
    public int jump(int[] nums) {
        int min = Integer.MAX_VALUE;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[nums.length - 1] = 0;
        
        
        
        for (int i = nums.length - 2; i >= 0; i --) {
            for (int j = nums[i] ; j > 0; j --) {
                int jump = Math.min(nums.length - 1, i + j);
                memo[i] = Math.min(memo[i], memo[jump]);
            }
            if (memo[i] != Integer.MAX_VALUE){
                memo[i] ++;
            }
        }
        
        return memo[0];
        
    }
}