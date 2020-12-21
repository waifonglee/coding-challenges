class Solution {
    /*
    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects
    of the same color are adjacent, with the colors in the order red, white, and blue.
    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
    
    quicksort but 3 partitions
    Dutch National Flag Problem
    */
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0; //Also pointer for current element
        int blue = nums.length - 1;
       
        if (nums.length <= 1) {
            return;
        }
        
        while (white <= blue) {
            if (nums[white] == 0) {
                swap(nums, white, red);
                red ++;
                white ++;
            } else if (nums[white] == 1) {
                white ++;
            } else {
                swap(nums, white, blue);
                blue --;
            }
        }
        
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}