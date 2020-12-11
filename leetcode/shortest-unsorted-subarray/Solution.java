//O(1) space O(n) time
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int start = 1;
        int end = 0;
        
        //everytime we see an element from left to right, smaller than max so far, the subarray needs to end at i
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (max > nums[i]) {
                end = i;
            }
        }
        

        //everytime we see an element from right to left bigger than the min so far, the subarray needs to start at i.
        for (int j = nums.length - 1; j >= 0; j--) {
            min = Math.min(min, nums[j]);
            if (nums[j] > min) {
                start = j;
            }
        }
        
        return end - start + 1;
    }
        
}