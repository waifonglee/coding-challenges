class Solution {
    /*
    
    Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
    add spaces in s to construct a sentence where each word is a valid dictionary word. 
    Return all such possible sentences.

    Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.


    DFS + DP using hashmap
    */
    
    public HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        Set<String> set = new HashSet<String>(wordDict);
        return search(s, set, 0);
    }
    
    public ArrayList<String> search(String s, Set<String> set, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        
        ArrayList<String> ans = new ArrayList<>();
        
        if (s.length() == 0) { //Base case
            ans.add("");
            return ans;
        }
        
        for (String word: set) {
            if (s.startsWith(word)) {
                ArrayList<String> lst = search(s.substring(word.length()), set, start + word.length());
                for (String x: lst) {
                    if (x.isEmpty()) {
                        ans.add(word);
                    } else {
                        ans.add(word + " " + x);
                    }
                }
            }
        }
        
        map.put(start, ans);
        return ans;
    }
}