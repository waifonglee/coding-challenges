class Solution {
    
    /*
    Given an array nums of n integers where n > 1,  
    return an array output such that output[i] is equal to the product of all the elements of nums 
    except nums[i].
    
    O(1) space: 1 array which is ans array, compute ans[i] = product of all on the left of i
    after the loop, right will be a variable and just multiply it with arr[j] starting from the back
    */
    
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        
        for(int i = 1; i < nums.length - 1; i++) {
            int l = i;
            int r = nums.length - 1 - i;
            left[l] = nums[l] * left[l - 1];
            right[r] = nums[r] * right[r + 1];
        }
                
        //System.out.println(right[nums.length - 3]);
        
        int[] ans = new int[nums.length];
        ans[0] = right[1];
        ans[nums.length - 1] = left[nums.length - 2];
        for (int j = 1; j < nums.length - 1; j ++) {
            ans[j] = left[j - 1] * right[j + 1];
        } 
        return ans;
        
    }
}