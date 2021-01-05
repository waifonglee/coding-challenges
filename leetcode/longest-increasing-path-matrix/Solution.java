class Solution {
    /*
    Given an integer matrix, find the length of the longest increasing path.

    From each cell, you can either move to four directions: left, right, up or down. 
    You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

    DFS + DP
    */
    int[][] memo;
    int max;
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        memo = new int[matrix.length][matrix[0].length]; //Max increasing length from memo[i][j]
        max = 0;
       
        
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                max = Math.max(max, search(matrix, i, j));
            }
        }
    
        return max;
    }
    
    public int search(int[][] matrix, int row, int col) { //returns longest from matrix[row][col]
        //System.out.println(row + " " + col);
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        
        int ans = 1;
        
        for (int[] d:dir) {
            if (row + d[0] >= matrix.length || row + d[0] < 0) {
                continue;
            }
            if (col + d[1] >= matrix[0].length || col + d[1] < 0) {
                continue;
            }
            if (matrix[row + d[0]][col + d[1]] <= matrix[row][col]) {
                continue;
            }
            ans = Math.max(ans, 1 + search(matrix, row + d[0], col + d[1]));
        }
        
        memo[row][col] = ans;
        return memo[row][col];
        
    }
}