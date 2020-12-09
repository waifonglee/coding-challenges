// Very slow solution
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int conc = 1;
        int current = 0;
        for (int i = 0; i < nums.length; i ++) {
            current = nums[i];
            if (map.containsKey(current)) {
                continue;
            }
            
            if (map.containsKey(current - 1) && map.containsKey(current + 1)) {
                int left = map.get(current - 1);
                int right = map.get(current + 1);
                map.replace(current - left, left + right + 1);
                map.replace(current + right, left + right + 1);
                map.put(current, left + right + 1);
                conc = Math.max(conc, left + right + 1);
                continue;
            }
            
            if (map.containsKey(current - 1)) {
                int currConc = map.get(current - 1) + 1;
                map.put(current, currConc);
                map.replace(current - currConc + 1, currConc);
                conc = Math.max(conc, currConc);
                continue;
            }
            if (map.containsKey(current + 1)) {
                int currConc = map.get(current + 1) + 1;
                map.put(current, currConc);
                map.replace(current + currConc - 1, currConc);
                conc = Math.max(conc, currConc);
                continue;
            }
            
            map.put(current, 1);
            
        }
        return conc;
    }
}

//Faster solution from leetcode,https://leetcode.com/problems/longest-consecutive-sequence/solution/
//Only start searching when a number is the start of a sequence hence its O(n) linear
class Solution2 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}