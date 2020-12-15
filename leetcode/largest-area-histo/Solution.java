class Solution {
    /*
    Given n non-negative integers representing the histogram's bar height where the width 
    of each bar is 1, find the area of largest rectangle in the histogram.
    */

    //stack indices whose height[i] is in increasing order, once reach a shorter
    //height, calculate the max height of that consecutive increasing order portion
    //at the end, will hv some not consecutive increasing order height, use them to 
    //calculate the portions with that height[i].
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        if (heights.length <= 0) {
            return 0;
        }
        
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() > -1 && heights[stack.peek()] > heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() -1));
            }
            stack.push(i);
        }
        
        while (stack.size() > 0 && stack.peek() > -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() -1));
        }
        // between stack.peek() and stack.pop(), all was taller than stack.pop(), hence we calc the area in between
        
        return max;
    }
}
