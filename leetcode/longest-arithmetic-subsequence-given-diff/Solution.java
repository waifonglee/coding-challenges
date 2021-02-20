import java.util.HashMap;

class Solution {
    /*
    Given an integer array arr and an integer difference, return the length of the longest subsequence in arr w
    hich is an arithmetic sequence such that the difference between adjacent elements in the subsequence 
    equals difference.
    A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing 
    the order of the remaining elements.


    */
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int j = 0; j < arr.length; j++) {
            int num = arr[j] - difference;
            map.put(arr[j], map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(arr[j]));
        }
        return max;
    }
}