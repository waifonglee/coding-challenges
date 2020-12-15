/*
Given an unsorted integer array nums, find the smallest missing positive integer.

Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra 
space?

Observations:
missing number must be in the range 1 to length + 1

1.remove all elements that are out of range
2.use the index as hash for value. for eg. if nums[i] = x, use nums[x] to indicate that we have seen x
3.for nums[p] that have not been seen, return p

*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        int val = nums.length + 2;
        
        //this loop is to ignore out of range of 1...n+1 numbers
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
            //make everything seen into negative. curr-1 because we working with 0 index
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

