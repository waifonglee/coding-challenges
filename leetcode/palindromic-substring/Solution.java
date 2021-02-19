class Solution {
    /*
    Given a string, your task is to count how many palindromic substrings in this string.

    The substrings with different start indexes or end indexes are counted as different substrings even 
    they consist of same characters.

    dp[i][j] == if i to j is palindrome
    
    */
    boolean[][] dp;
    int sum;
    public int countSubstrings(String s) {
        dp = new boolean[s.length()][s.length()];
        sum = 0;
        for (int i = s.length() - 1; i >= 0; i --) { //start from the last letter so that when we populate all the dp[start + 1] first
            isPalin(s, i);
        
        }
        return sum;
        
    }

    public void isPalin(String s, int start) {
        if (start >= s.length()) {
            return;
        }
        for (int p = start; p < s.length(); p ++) {
            if (s.charAt(start) == s.charAt(p) && (p - start <= 2 || dp[start + 1][p - 1])) {
                if (!dp[start][p]) {
                    sum++;
                }
                dp[start][p] = true;
            }
        }
    }
}