class Solution {
    /*
    Hashmap key = sum[i] i.e sum from index 0 to i, value = num of times it happens
    sum[i] - sum[j] = sum from index i to j.
    sum[i] - sum[j] = k, sum[j] = sum[i] - k
    */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
             
        }
        
        return count;
    }
}

/*
O(n^2) solution: for each element in the array, run sum of each endpoint in the arr until the end
*/