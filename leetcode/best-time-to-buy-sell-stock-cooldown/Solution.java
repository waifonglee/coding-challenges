class Solution {
    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

    */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] buy = new int[prices.length + 1]; //buy[i] = max profit if we buy or cooldown on ith day
        int[] sell = new int[prices.length + 1]; //sell[i] = max profit if we sell or cooldown on ith day
        buy[0] = buy[1] = -prices[0];
        for (int i = 2; i < prices.length + 1; i++) {
            buy[i] = Math.max(sell[i - 2] - prices[i - 1], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i - 1], sell[i - 1]);
        }
        return Math.max(buy[prices.length], sell[prices.length]);
    }
}