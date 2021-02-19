class Solution {
    /*
    You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now    you have 2 symbols + and -. For each integer, you should choose one from + and - as     its new symbol.

    Find out how many ways to assign symbols to make sum of integers equal to target S.
    
    dp[i] = i can be made from the numbers traversed
    */
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int n:nums) {
            sum += n;
        }
        if (S > sum || S < -sum) {
            return 0;
        }

        int[] dp = new int[2 * sum + 1];

        dp[sum] = 1;
        for (int num:nums) {
            int[] newDp = new int[2 * sum + 1];
            for (int i = 0; i < dp.length; i ++) {
                if (dp[i] == 0) {
                    continue;
                }
                newDp[i + num] += dp[i];
                newDp[i - num] += dp[i];
            }
            dp = newDp;
        }

        return dp[S + sum];
    }
}