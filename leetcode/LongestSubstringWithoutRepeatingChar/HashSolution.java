class Solution { //use hashmap map char to index  
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        int maxNum = 0;
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            if (map.containsKey(current) && map.get(current) >= start) {
                maxNum = Math.max(maxNum, end - start + 1);
                start = map.get(current) + 1;
                end = i;
                map.replace(current, i);
            } else {
                map.put(current, i);
                end = i;
            }
        }
        
        maxNum = Math.max(maxNum, end - start + 1);
        return maxNum;
    }
}
