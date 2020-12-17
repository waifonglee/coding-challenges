class Solution {
    /*
    Given an array of strings strs, group the anagrams together. You can
    return the answer in any order.
    An Anagram is a word or phrase formed by rearranging the letters of a
    different word or phrase, typically using all the original letters
    exactly once.

    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    
    we can do prime multiplication (mapping each char to a prime num) too but overflow if string is too long
    
    M1: sort and map
    M2 (this): put count in hashmap and compare hashmaps
    
    */
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new LinkedList<>();
        if (strs.length == 0) {
            ans.add(Arrays.asList(new String[] {""}));
            return ans;
        }
        
        HashMap<HashMap, List<String>> map = new HashMap<>();
        
        for (String s: strs) {
            HashMap<Character, Integer> freq = new HashMap<>();
            for (int i = 0; i < s.length(); i ++) {
                freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
            }
            if (map.containsKey(freq)) {
                List<String> curr = map.get(freq);
                curr.add(s);
                map.put(freq, curr);
            } else {
                List<String> toPut = new LinkedList<String>();
                toPut.add(s);
                map.put(freq, toPut);
            }
        }
        
        for (HashMap key: map.keySet()) {
            ans.add(map.get(key));
        }
        
        return ans;
          
    }
}