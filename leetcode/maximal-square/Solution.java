class Solution {
    /*
    Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
    
    DP. memo[i][j] stores max square built from i, j being the upper left square
    */
    int maxArea;
    int[][] memo;
    public int maximalSquare(char[][] matrix) {
        int col_len = matrix[0].length;
        int row_len = matrix.length;
        if (col_len == 0 || row_len == 0) {
            return 0;
        }
        memo = new int[row_len][col_len];
        for (int[] row : memo){
            Arrays.fill(row, -1);
        }
        maxArea = 0;
        for (int i = 0; i < row_len; i++) {
            for (int j = 0; j < col_len; j++) {
                int area = findmax(matrix, i, j);
                maxArea = Math.max(area * area, maxArea);
            }
        }
        return maxArea;
    }

      public int findmax(char[][] matrix, int r, int c) {
        int col_len = matrix[0].length;
        int row_len = matrix.length;
        if (r >= row_len || c >= col_len) {
            return 0;
        }
        if (memo[r][c] != -1) {
            return memo[r][c];
        }
        if (matrix[r][c] == '0') {
            memo[r][c] = 0;
            return 0;
        }
        memo[r][c] = 1 + Math.min(findmax(matrix, r + 1, c), Math.min(findmax(matrix, r, c+1), findmax(matrix, r+1, c+1)));
        return memo[r][c];
    }
}