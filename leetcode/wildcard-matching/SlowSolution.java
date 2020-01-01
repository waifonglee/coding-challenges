class Solution {
    Boolean[][] memo;
    
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        
        return checkChar(0, 0, s, p);
    }
    
    public boolean checkChar(int i, int j, String s, String p) {
        if (i > s.length()) {
            return false;
        }
        
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        boolean ans;
        if (j == p.length()) {
            ans = i == s.length();
        } else {
            boolean match = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'));
            
            if (p.charAt(j) == '*') {
                ans = checkChar(i + 1, j, s, p) || checkChar(i + 1, j + 1, s, p) || 
                    checkChar(i, j + 1, s, p);
            } else {
                ans = match && checkChar(i + 1, j + 1, s, p);
            }
        }
        
        memo[i][j] = ans;
        return ans;
    }
}
