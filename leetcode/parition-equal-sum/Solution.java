class Solution {
    /*
    Given a non-empty array nums containing only positive integers, 
    find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

    */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        
        if (sum % 2 == 1) {
            return false;
        }

        sum = sum / 2;
        if (sum == 0) {
            return false;
        }

        boolean[] dp = new boolean[sum + 1]; //dp[i] = whether theres any sum = i in this array
        dp[0] = true;

        for (int j = 0; j < nums.length; j ++) {
            for (int p = sum; p > 0; p --) {
                int num = nums[j];
                if (p >= num) {
                    dp[p] = dp[p] || dp[p - num];
                }
            }
        }
        return dp[sum]; 
    }
}