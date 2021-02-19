import java.util.LinkedList;
import java.util.Queue;

class Solution {
    /*
    Given a m x n grid filled with non-negative numbers, find a path from top left to
    bottom right, which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.
    */
    public int minPathSum(int[][] grid) {
        int col_l = grid[0].length;
        int row_l = grid.length;
        int[][] dp = new int[row_l][col_l];
        for (int[] r:dp) {
            for (int c:r) {
                r[c] = Integer.MAX_VALUE;
            }
        }
       //row, col
        dp[0][0] = grid[0][0];
        for (int r = 0; r < row_l; r++ ){
            for (int c = 0; c < col_l; c++) {
                if (r == 0 && c == 0) {
                    continue;
                }
                int top = r - 1 >= 0 ? dp[r - 1][c] : Integer.MAX_VALUE;
                int left = c - 1 >= 0 ? dp[r][c - 1] : Integer.MAX_VALUE;
                dp[r][c] = Math.min(top, left) + grid[r][c];
    
                
            }
        }
            
        //System.out.println(Arrays.deepToString(dp));
        return dp[row_l - 1][col_l - 1];
        
    }
}