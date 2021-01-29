class Solution {
    /*
    Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle
    containing only 1's and return its area.
    
    turn it into largest rectangle in histogram question

    */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length + 1];
        int area = 0;
        heights[matrix[0].length] = 0; //put 1 0 there so tt we don have to loop again at the end of the col loop
        
        for (int row = 0; row < matrix.length; row ++) {
            Stack<Integer> stack = new Stack<Integer>();
            for (int col = 0; col < heights.length; col ++) {
                if (col < matrix[0].length) {
                    if (matrix[row][col] == '1') {
                        heights[col] += 1;
                    } else {
                        heights[col] = 0;
                    }
                }
                
                if (stack.isEmpty() || heights[col] >= heights[stack.peek()]) {
                    stack.push(col);
                } else {
                    while (!stack.isEmpty() && heights[stack.peek()] > heights[col]) {
                        int popped = stack.pop();
                        if (stack.isEmpty()) {
                            area = Math.max(area, (col) * heights[popped]);
                        } else {
                            area = Math.max(area, (col - stack.peek() - 1) * heights[popped]);
                        }
                
                        
                    }
                    stack.push(col);
                }
                
            
            }
               
        }
        
        return area;
        
    }
}