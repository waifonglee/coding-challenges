class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int neededNum = target - current;
            if (map.containsKey(neededNum)) {
                indices[0] = map.get(neededNum);
                indices[1] = i;
                break;
            } else {
                map.put(current, i);
            }
        } 
        return indices;
    }
}
