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
