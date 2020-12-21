class Solution {
    /*
    A peak element is an element that is strictly greater than its neighbors.
    Given an integer array nums, find a peak element, and return its index. If the array contains
    multiple peaks, return the index to any of the peaks.
    You may imagine that nums[-1] = nums[n] = -∞.
    */
    public int findPeakElement(int[] nums) {
        return binary(nums, 0, nums.length - 1);
        
    }
    
    public int binary(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        
        int mid = left + ((right - left) / 2);
        int midVal = nums[mid];
        if  (mid < nums.length - 1 && midVal < nums[mid + 1]){
            return binary(nums, mid + 1, right );
        } else if (mid > 0 && midVal < nums[mid - 1])  {
            return binary(nums, left, mid - 1);
        } else {
            return mid;
        }
    }
}