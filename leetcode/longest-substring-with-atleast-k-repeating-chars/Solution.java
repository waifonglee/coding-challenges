class Solution {
    /*
    Given a string s and an integer k, return the length of the longest substring of s such
    that the frequency of each character in this substring is greater than or equal to k.
    
    Divide & conquer(this) : everytime u see 1 letter that has freq < k in the string, tt
    character can never be in the final substring hence we divide it into 0...j-1,
    j+1...s.length - 1
    
    SLiding window: calc number of unique chars in the string, do numUniqueChars iteration
    of sliding window, and cal the max of all iteration. for eg. we start w 1 unique char
    and only calc substring with 1 unique char and tt it appears more than >= k times in the
    string 
    */
    public int longestSubstring(String s, int k) {
        return process(s, k, 0, s.length() - 1);
    }
    
    public int process(String s, int k, int l, int r) {
        if ((r + 1) < k) {
            return 0;
        }
        
        HashMap<Character, Integer> freq = new HashMap<>(); //or can use array[256]
        for (int i = l; i < r + 1; i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        int mid = -1;
        for (int j = l; j < r + 1; j++) {
            if (freq.get(s.charAt(j)) >= k) {
                continue;
            } else {
                mid = j;
                break;
            }
        }
        
        if (mid != -1) {
            return Math.max(process(s, k, l, mid - 1), process(s, k, mid + 1, r));
        }
        return r - l + 1; 
    }
}