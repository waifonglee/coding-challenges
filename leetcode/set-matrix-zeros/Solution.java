class Solution {
    /*
    Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

    Follow up:

    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution. 
    (use set to store the rows and cols to color)
    Could you devise a constant space solution?
    (use the index 0th element of each row and col to determine if we should color.
    row and col 0 will be kept in variables since they intercept)
    */
    public void setZeroes(int[][] matrix) { 
        boolean rowZero = false;
        boolean colZero = false;
        
        for (int r = 0; r < matrix.length; r ++) {
            for (int c = 0; c < matrix[0].length; c ++) {

                if (matrix[r][c] == 0) {
                    if (r == 0) {
                        rowZero = true;
                    }
                    
                    if (c == 0) {
                        colZero = true;
                    }
                    
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        
        for (int row = 1; row < matrix.length; row ++) { //search from row 1
            if (matrix[row][0] == 0) {
                colorRow(matrix, row);
            }
        }
        
        for (int col = 1; col < matrix[0].length; col ++) { //search from col 1
            if (matrix[0][col] == 0) {
                colorCol(matrix, col);
            }
        }
        
        if (rowZero) {
            colorRow(matrix, 0);
        }
        
        if (colZero) {
            colorCol(matrix, 0);
        }
    }
    
    public void colorRow(int[][] matrix, int r) {
        for (int i = 0; i < matrix[0].length; i ++) {
            matrix[r][i] = 0;
        }
    }
    
    public void colorCol(int[][] matrix, int c) {
        for (int i = 0; i < matrix.length; i ++) {
            matrix[i][c] = 0;
        }
    }
}