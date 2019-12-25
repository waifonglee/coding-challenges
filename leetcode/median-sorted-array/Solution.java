class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        double median = 0;
        int half = sum / 2;
        
        if (nums1.length == 0 && sum % 2 == 0) {
            median = (nums2[half - 1] + nums2[half]) / (double) 2;
            return median;
        }
        
        if (nums1.length == 0 && sum % 2 != 0) {
            median = nums2[half];
            return median;
        }
        
        if (nums2.length == 0 && sum % 2 == 0) {
            median = (nums1[half - 1] + nums1[half]) / (double) 2;
            return median;
        }
        
        if (nums2.length == 0 && sum % 2 != 0) {
            median = nums1[half];
            return median;
        }
        
        int j = 0;
        int k = 0;
        double prev = 0;
        for (int i = 0; i < half + 1; i++) {
            prev = median;
            if (j < nums1.length && k < nums2.length) { 
                if (nums1[j] <= nums2[k]) {
                    median = nums1[j];
                    j++;
                } else {
                    median = nums2[k];
                    k++;
                }
            } else if (j < nums1.length) {
                median = nums1[j];
                j++;
            } else {
                median = nums2[k];
                k++;
            }
        }
        
        if (sum % 2 == 0) {
           median = (prev + median) / (double) 2;
        }
        
        return median;
    }
}
