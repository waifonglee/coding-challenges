class Solution {
    /*
    Given n non-negative integers representing an elevation map where the width of each bar is 1,
     compute how much water it can trap after raining.
    Example 1:
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (black section) is represented by 
    array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) 
    are being trapped.
    */    
    //2 pointers faster solution
    public int trap(int[] height) {
        if (height.length < 3 || height == null) {
            return 0;
        }
        
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        
        for (int i = 0; i < height.length; i++) {
            if (height[left] > height[right]) {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    area += rightMax - height[right]; //because height[left] is greater than rightMax
                }
                right--;
            } else {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    area += leftMax - height[left];
                }
                left ++;
            }
        }
        
        return area;
    }
}
    
