class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) < 3:
            return 0
        
        left = 0
        right = len(height) - 1
        leftMax = 0
        rightMax = 0
        area = 0
        
        for i in range(0, len(height)) :
            if height[left] > height[right]:
                if height[right] > rightMax:
                    rightMax = height[right]
                else:
                    area += rightMax - height[right]
                
                right -= 1
                    
            else:
                if height[left] > leftMax:
                    leftMax = height[left]
                else:
                    area += leftMax - height[left]
                left += 1
        return area