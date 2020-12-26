class Solution {
    /*
    Given an integer array nums, return the length of the longest strictly increasing subsequence.
    A subsequence is a sequence that can be derived from an array by deleting some or no elements
    without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the
    array [0,3,1,6,2,2,7].
    [7, 7, 7] output = 1

    M1: DP O(n^2)
    M2: binary search with DP O(nlogn)
    */
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        if (nums.length == 0) {
            return 0;
        }
        memo[0] = 1;
        int globalMax = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j ++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(memo[j] + 1, max);
                }
            }
            memo[i] = max;
            globalMax = Math.max(globalMax, max);
        }
        return globalMax;
    }
}

// M2: binary search with DP 
// for more info: https://algorithmsandme.com/longest-increasing-subsequence-in-onlogn/
public int lengthOfLIS(int[] nums) {
    int[] arr = new int[nums.length]; //store the last element of each list
    int len = 0; //length of longest list
    
    for(int i = 0; i < nums.length; i ++) {
        //binary search to find the smallest element greater than nums[i]
        int ind = Arrays.binarySearch(arr, 0, len, nums[i]); 
        
        if (ind < 0) { 
            ind = -(ind + 1);
        }
        arr[ind] = nums[i];
        
        if (ind == len) { //if nums[i] is appended to a new list
            len ++;   
        }
    }
    return len;
}