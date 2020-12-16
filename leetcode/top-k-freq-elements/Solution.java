class Solution {
    /*
    Given a non-empty array of integers, return the k most frequent elements.
    */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); //store freq of each unique num
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<>(k, 
                                    (x, y) -> Integer.compare(map.get(x), map.get(y))); 
                                    //queue according to frequency
      
        for (Integer key : map.keySet()) {
            if (q.size() < k) {
                q.offer(key);
            } else {
                if (map.get(key) > map.get(q.peek())) {
                    q.poll();
                    q.offer(key);
                }
            }
        }
    
        int[] ans = new int[k];
        int p = 0;
        while (q.size() != 0) {
            ans[p] = q.poll();
            p ++;
       }
        return ans;

    }
}