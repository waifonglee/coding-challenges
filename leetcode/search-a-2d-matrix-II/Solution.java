class Solution {
    /*
    
    Write an efficient algorithm that searches for a target value in an m x n integer matrix.
    The matrix has the following properties:
    1.Integers in each row are sorted in ascending from left to right.
    2.Integers in each column are sorted in ascending from top to bottom.
    
    start from top right.
    if target > current, eliminate the current row since everything on the same row is smaller than target
    else, eliminate the current col since everything on the same col is bigger than the target.
    
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        int current = 0;
        boolean doesExist = false;
        
        while (row < matrix.length && col >= 0) {
            current = matrix[row][col];
            if (current == target) {
                doesExist = true;
                break;
            }
            
            if (current > target) {
                col --;
            } else {
                row ++;
            }
            
            
        }
        
        return doesExist;
    }
}