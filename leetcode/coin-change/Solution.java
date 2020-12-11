// can prolly be faster
class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        for (int i = 0; i < amount + 1; i ++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
            
        int ans = run_dp(coins, amount);
        
        if (ans > amount) {
            return -1;
        }
        return ans;
    }
    
    public int run_dp(int[] coins, int amount) {
        if (amount < 0){
            return (int)10E4 + 1;
        }
        //System.out.println(dp[0]);
        if (dp[amount] != Integer.MAX_VALUE) {
            return dp[amount];
        }
        
        
        
        int num = (int)10E4 + 1;
        for (int j = 0; j < coins.length; j++) {
            num = Math.min(num, run_dp(coins, amount - coins[j]) + 1);
        }
        dp[amount] = num;
        return dp[amount];
    }
        
}