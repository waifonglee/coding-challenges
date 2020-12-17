class Solution {
    /*
    Find the kth largest element in an unsorted array. Note that it is the kth largest element in the
    sorted order, not the kth distinct element.
    Input: [3,2,3,1,2,4,5,5,6] and k = 4
    Output: 4
    
    use quickselect
    */
    public int findKthLargest(int[] nums, int k) {
        
        return quickSelect(k, 0, nums.length - 1, nums);
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int quickSelect(int k, int l, int r, int[] nums) {
        int pivotVal = nums[l];
        int pivotInd = l;
        swap(nums, l, r);   
    
        for (int i = l; i < r ; i ++) {
            if (nums[i] <= pivotVal) {
                swap(nums, i, pivotInd);
                pivotInd ++;
            }
        }
        swap(nums, pivotInd, r);
        
        if (nums.length - pivotInd == k) {
            return nums[pivotInd];
        }
    
        if (nums.length - pivotInd < k) {
            return quickSelect(k, l, pivotInd - 1, nums);
        } else {
            return quickSelect(k, pivotInd + 1, r, nums);
        }
    }
        
}