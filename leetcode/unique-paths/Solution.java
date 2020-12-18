class Solution {
    /*
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram
    below).

    The robot can only move either down or right at any point in time. The robot is trying
    to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

    How many possible unique paths are there?
    
    combination!!!
    choose route to go right from total route n + m - 2
    Combination(N, k) = n! / (k!(n - k)!)
    C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
    */
    
    public int uniquePaths(int m, int n) {
    double value = 1;
    for (int i = 1; i <= n - 1; i++) {
        value *= ((double) (m + i - 1) / (double) i);
    }
    return (int) Math.round(value);
}
    
    /*
    too slow recursion
    public int uniquePaths(int m, int n) {
    //coordinate aim: (n-1, m-1)
        return helper(0, 0, n - 1, m - 1);
    }
    
    
    public int helper(int x, int y, int aimX, int aimY) {
        if (x == aimX && y == aimY) {
            return 1;
        }
        if (x > aimX || y > aimY) {
            return 0;
        }
        return helper(x + 1, y, aimX, aimY) + helper(x, y + 1, aimX, aimY);   
    }
    */
}