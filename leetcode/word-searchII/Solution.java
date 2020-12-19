class Solution {
    /*
    Given an m x n board of characters and a list of strings words, return all words on the
    board.
    Each word must be constructed from letters of sequentially adjacent cells, where
    adjacent cells are horizontally or vertically neighboring. The same letter cell may not
    be used more than once in a word.
    
    why use trie? 
    when we dfs, and come across a character that does appear in any word, 
    we dont have to search it (pruning the graph).

    */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (String s: words){
            insert(s, root);
        }
        
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                dfs(ans, i, j, root, board); 
            }
        }
        
        return ans;
        
    }
    
    public void dfs(List<String> ans, int r, int c, TrieNode p, char[][] board) {
        //System.out.println(r + " " + c);
        if (r >= board.length || r < 0 || c < 0 || c >= board[0].length) {
            return;
        }
        char curr = board[r][c];
        if (curr == '#' || !p.containsKey(curr)) {
            return;
        }
        //System.out.println("current = " + curr);
        TrieNode next = p.get(curr);
        if (next.isEnd) {
            ans.add(next.word);
            //System.out.println("found word: " + next.word);
            next.unEnd();
        }
        
        board[r][c] = '#';
        dfs(ans, r + 1, c, next, board);
        dfs(ans, r - 1, c, next, board);
        dfs(ans, r, c + 1, next, board);
        dfs(ans, r, c - 1, next, board);
        board[r][c] = curr;
        
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
            //System.out.println(current.word);
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