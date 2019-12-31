class Solution {
    public int firstMissingPositive(int[] nums) {
        int val = nums.length + 2;
        
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] > nums.length || nums[i] <= 0) {
                nums[i] = val;
            }
        }
        
        for (int j = 0; j < nums.length; j++) {
            int curr = Math.abs(nums[j]);
            if (curr == val) {
                continue;
            }
            
            nums[curr - 1] = nums[curr - 1] < 0 ? nums[curr - 1] : -nums[curr - 1];   
        }
        
        int ans = nums.length + 1;
        for (int k = 0; k < nums.length; k++) {
            int current = nums[k];
            
            if (current > 0) {
                ans = k + 1;
                break;
            }
        }
        
        return ans;
    }
}
