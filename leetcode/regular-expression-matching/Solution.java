class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return checkChar(0, 0, s, p);
    }
    
    
    public boolean checkChar(int i, int j, String input, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        boolean answer;
        
        if (j == pattern.length()) {
            answer = i == input.length();
        } else {
            boolean match = 
                (i < input.length() && (input.charAt(i) == pattern.charAt(j) || 
                pattern.charAt(j) == '.'));
            
            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                if (match) {
                    answer = checkChar(i + 1, j, input, pattern) || 
                        checkChar(i, j + 2, input, pattern); //accomodate for cases like (aaa, a*a) make the pointer go to the last a in pattern instead of staying at the first a 
                } else {
                    answer = checkChar(i, j + 2, input, pattern);
                }
                  
            } else {
                answer = match && checkChar(i + 1, j + 1, input, pattern);
            }
        }
        
        memo[i][j] = answer;
        return answer;
        
    }    
}

