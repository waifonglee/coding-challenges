class Solution {
    /*
    You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
    */
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1]; //dp[i][j] means combi of first i coins use to make amt j 
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i ++) {
            dp[i][0] = 1;
            for (int j = 1; j < amount + 1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
        
}