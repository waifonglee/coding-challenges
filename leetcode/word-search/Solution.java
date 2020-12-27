class Solution {
    /*
    Given an m x n board and a word, find if the word exists in the grid.
    The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are
    horizontally or vertically neighboring. The same letter cell may not be used more than once.
    
    */
    public boolean exist(char[][] board, String word) {
        boolean found = false;
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j)) {
                    found = true;
                    break;
                }
            }
        }
        return found;
        
    }
    //row = y coordinate, col = x coordinate
    public boolean dfs(char[][] board, String word, int ind, int r, int c) {
        if (r >= board.length || r < 0 || c < 0 || c >= board[0].length) {
            return false;
        }
        
        char current = board[r][c];
        if (current == '#' || current != word.charAt(ind)) {
            return false;
        }
        if (ind == word.length() - 1) {
            return true;
        }
        
        board[r][c] = '#';
        boolean search = dfs(board, word, ind + 1, r, c + 1) || 
            dfs(board, word, ind + 1, r, c - 1) || dfs(board, word, ind + 1, r + 1, c) ||
            dfs(board, word, ind + 1, r - 1, c);
        board[r][c] = current;
        return search;
        
    }
}