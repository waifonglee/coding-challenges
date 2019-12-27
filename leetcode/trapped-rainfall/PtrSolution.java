class Solution {
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
                    area += rightMax - height[right];
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
    
