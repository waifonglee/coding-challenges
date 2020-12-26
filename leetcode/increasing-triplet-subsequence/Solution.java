class Solution {
    /*
    Given an integer array nums, return true if there exists a triple of indices (i, j, k) 
    such that i < j < k and nums[i] < nums[j] < nums[k]. 
    If no such indices exists, return false.
    */
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE; //first val
        int mid = Integer.MAX_VALUE; //second val
        boolean found = false;
        
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] <= min) { //<= to remove cases where nums[i] == min
                min = nums[i];
            } else if (nums[i] <= mid) { //<= to remove cases where nums[i] == mid
                mid = nums[i];
            } else {
                found = true;
                break;
            }
        }
        return found;
    }





    //solution altered from the problem : longest increasing subsequence
    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[3];
        int len = 0;
        for (int i = 0; i < nums.length; i++){
            int ind = Arrays.binarySearch(dp, 0, len, nums[i]);
            if (ind < 0) {
                ind = -(ind + 1);
            }
            dp[ind] = nums[i];
            
            if (ind == len) {
                len ++;
            }
            if (len == 3) {
                break;
            }
             
        }
        
        return len == 3;
        
    }
}