class Solution {
    /*
    Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine
    if s can be segmented into a space-separated sequence of one or more dictionary words.

    Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.
    
    Trie + DP
    */
    
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true;
        TrieNode root = new TrieNode();
        
        for (String word: wordDict) {
            insert(word, root);
        }
        
        //search every possible substring
        for (int i = 0; i < s.length(); i ++) {
            if (!memo[i]) {
                continue;
            }
            TrieNode current = root;
            for (int j = i; j < s.length(); j++) {
                if (current.containsKey(s.charAt(j))) {
                    current = current.get(s.charAt(j));
                    if (current.isEnd()) {
                        memo[j + 1] = true;
                    }
                } else {
                    break;
                }  
            }
        }
        
        return memo[s.length()];
        
    }
    
    public void insert(String word, TrieNode root) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i ++) {
            if (!current.containsKey(word.charAt(i))) {
                current.put(word.charAt(i), new TrieNode());
            }
            current = current.get(word.charAt(i));
        }
        current.setEnd();
        current.word = word;
    }
    
    
    class TrieNode {
        private TrieNode[] links;
        private boolean isEnd = false;
        public String word;

        public TrieNode() {
            links = new TrieNode[26];
        }

        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void unEnd() {
            isEnd = false;
        }
    }
}