class Solution {
//2 pointers solution
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (nums[i] > 0) { //if not negative, will never = 0
                break;
            }
            
            if (i > 0 && nums[i] == nums[i - 1]) { //skip same num
                continue;
            }
            
            int j = i + 1;
            int k = nums.length - 1;
            
            if (nums[k] < 0) { //if not positive, will never = 0
                    break;
            }
            
            int target = 0 - nums[i];
            
            while (j < k) {
                int sum = nums[j] + nums[k];
                
                if (sum == target) {
                    solution.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    
                    while(j < k  && nums[j] == nums[j - 1]) { //skip same num
                        j++;
                    }
                
                    while (j < k && nums[k] == nums[k + 1]) { //skip same num
                        k--;
                    }
                
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
            
        }
        return solution;
    }
}
        
