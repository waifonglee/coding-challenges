class Solution {
    public HashSet<Integer> done = new HashSet<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        
        for (int k = 0; k < nums.length; k++) {
            int num = nums[k];
            if (map.containsKey(num)) {
                int count = map.get(num);
                map.put(num, count + 1);
            } else {
                map.put(num, 1);
            }
        }
        
        for (int j = 0; j < nums.length; j++) {
            int cur = nums[j];
            
            if (!map.containsKey(cur)) {
                continue;
            }
            
            int c = map.get(cur);
            map.put(cur, c - 1);
            
            two_sum(cur, new HashMap<Integer, Integer>(map), nums,
                    j + 1, solution);
            
            map.remove(cur);
        }
        
        return solution;
    }
    
     public void two_sum(int fixed, HashMap<Integer, Integer> map,
                                       int[] arr, int start,
                                        List<List<Integer>> sol) {
        int left = 0 - fixed;
        for (int i = start; i < arr.length; i++) {
            int current = arr[i];
            if (!map.containsKey(current)) {
                continue;
            }
            int count = map.get(current);
            map.put(current, count - 1);
            int remaining = left - current;
            if (map.containsKey(remaining) && map.get(remaining) > 0) {
                List<Integer> slist = new ArrayList<>();
                slist.add(fixed);
                slist.add(current);
                slist.add(remaining);
                Collections.sort(slist);
                sol.add(slist);
            }
            map.remove(current);
        }
     }
}
