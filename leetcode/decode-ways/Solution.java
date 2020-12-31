class Solution {
    /*
    A message containing letters from A-Z can be encoded into numbers using the following mapping:

    'A' -> "1"
    'B' -> "2"
    ...
    'Z' -> "26"
    To decode an encoded message, all the digits must be mapped back into letters using the reverse of the
    mapping above (there may be multiple ways). For example, "111" can have each of its "1"s be mapped into
    'A's to make "AAA", or it could be mapped to "11" and "1" ('K' and 'A' respectively) to make "KA". Note
    that "06" cannot be mapped into 'F' since "6" is different from "06".

    Given a non-empty string num containing only digits, return the number of ways to decode it.

    The answer is guaranteed to fit in a 32-bit integer.
    
    uhh solution can be cleaned up more :')
    
    
    */
    public int[] memo;
    public boolean[] done;
    public int numDecodings(String s) {
        memo = new int[s.length() + 1];
        done = new boolean[s.length() + 1];
        if (s.charAt(s.length() - 1) == '0') {
            memo[s.length() - 1] = 0;
        } else {
            memo[s.length() - 1] = 1;
        }
        memo[s.length()] = 1;
        
        done[s.length()] = true;
        done[s.length() - 1] = true;
        
        return numWays(s, 0);
        
        
    }
    
    public int numWays(String s, int i) {
        //System.out.println(i);
        if (done[i]) {
            return memo[i];
        }
        
        int num = 0;
        for (int j = s.length() - 2; j >= i; j--) {
            
            if (s.charAt(j) != '0') {
                num += memo[j + 1];
            }
               
            String f = "" + s.charAt(j) + s.charAt(j + 1);
            //System.out.println(f);
            
            if (Integer.parseInt(f) <= 26 && s.charAt(j) != '0') {
                num += memo[j + 2];
            }
            memo[j] = num;
            done[j] = true;
            num = 0;
        }
        
        return memo[i];
    }
}