class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i ++) {
            if (!current.containsKey(word.charAt(i))) {
                current.put(word.charAt(i), new TrieNode());
            }
            current = current.get(word.charAt(i));
        }
        current.setEnd(); 
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        boolean found = true;
        for (int i = 0; i < word.length(); i ++) {
            if (!current.containsKey(word.charAt(i))) {
                found = false;
                break;
            } else {
                current = current.get(word.charAt(i));
            }
        }
        
        if (!current.isEnd) {
            found = false;
        }
        
        return found;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        boolean found = true;
        for (int i = 0; i < prefix.length(); i ++) {
            if (!current.containsKey(prefix.charAt(i))) {
                found = false;
                break;
            } else {
                current = current.get(prefix.charAt(i));
            }
        }
        return found;
        
    }
    
    class TrieNode {
        private TrieNode[] links;
        private boolean isEnd = false;
        
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
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */