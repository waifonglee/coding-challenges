class Solution {
    /*
    Given two strings word1 and word2, return the minimum number of operations required to 
    convert word1 to word2.
    You have the following three operations permitted on a word:
    Insert a character
    Delete a character
    Replace a character

    DP!!!
    Last char of word 1 = c, last char of word 2 = d
    f[i][j] = num of changes from word1[0, i) to word2[0, j)
    i.e convert first i character of word 1 to first j characters of word 2
    if we 
    1. insert d after c, f[i][j] = f[i][j-1] + 1
    2. delete c, f[i][j] = f[i-1][j] + 1
    3. replace c with d, f[i][j] = f[i-1][j-1] + 1
    
    */
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        /*
        For all 0 index, since i changes needed from a 0 length string to i length string
        */
        for(int m = 0; m <= word1.length(); m++) {
            memo[m][0] = m;
        }
        for(int k = 0; k <= word2.length(); k++) {
            memo[0][k] = k;
        }
            
        for(int i = 0; i < word1.length(); i ++) {
            for(int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    memo[i + 1][j + 1] = memo[i][j];
                } else {
                    int insert = memo[i + 1][j] + 1;
                    int delete = memo[i][j + 1] + 1;
                    int replace = memo[i][j] + 1;
                    
                    memo[i + 1][j + 1] = Math.min(insert, Math.min(delete, replace));
                    
                }
            }
        }
        return memo[word1.length()][word2.length()];
        
        
    }
}