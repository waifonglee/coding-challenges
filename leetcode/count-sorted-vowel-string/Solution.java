class Solution {
    /*
    Given an integer n, return the number of strings of length n that consist only of vowels 
    (a, e, i, o, u) and are lexicographically sorted.
    A string s is lexicographically sorted if for all valid i, 
    s[i] is the same as or comes before s[i+1] in the alphabet.
    */
    public int countVowelStrings(int n) {
        int[] dp = new int[256];
        char[] s = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < n; i ++) {
            int[] newDp = new int[256];
            for (char c: s) {
                if (i == 0) {
                    newDp[c] = 1;
                    continue;
                }
                for(char x:s) {
                    if (x > c) {
                        break;
                    }
                   
                    newDp[c] += dp[x];
                }
            }
            //System.out.println(Arrays.toString(newDp));
            dp = newDp;
        }
        int sum = 0;
        for (char p:s) {
            sum+=dp[p];
        }
        return sum;
        
    }
}