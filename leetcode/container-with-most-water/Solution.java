/*
Given n non-negative integers a1, a2, ..., an , 
where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). 
Find two lines, which, together with the x-axis forms a container, 
such that the container contains the most water.

Notice that you may not slant the container.
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
In this case, the max area of water (blue section) the container can contain is 49.

situation when a new max is formed:
leftmax increased, calculate area between new leftmax and rightmax, same for if rightmax increased
compare new max and old max area
only increment/decrement left/right for the min between height[left] and height[right] 
since the only way for the max area to increase is if the smaller side reaches a greater max
*/

class Solution {
    //2 pointer approach
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        
        if (height.length < 2 || height == null) {
            return 0;
        }
        
        for (int i = 0; i < height.length; i ++) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                    water = Math.max(water, (right - left) * height[left]);
                }
                left ++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                    water = Math.max(water, (right - left) * height[right]);
                }
               
                right --;
            }
        }
        
        return water;
    }
}
