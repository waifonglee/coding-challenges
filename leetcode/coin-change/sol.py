import sys
dp = {}
dp[0] = 0

def coinChange(coins, amount):
    global dp
    if amount in dp:
        return dp[amount]
    
    if amount < 0:
        return 10**4 + 1
    
    num = 10**4 + 1
    for coin in coins:
        num = min([num, coinChange(coins, amount - coin)  + 1])
        #print(str(coinChange(coins, amount - coin)))
        #print(str(num) + " current amount: " + str(amount - coin))
    
    dp[amount] = num
    #print(dp)

    return dp[amount]

def coinChange2(coins, amount):
    if len(coins) == 0:
        return -1
    ans = coinChange(coins, amount)
    if ans > amount:
        return -1
    return ans

ans = coinChange2([1,2,5], 11)
print(str(ans))

