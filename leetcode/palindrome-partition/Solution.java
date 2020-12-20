class Solution {
    /*
    Given a string s, partition s such that every substring of the partition is a palindrome.
    Return all possible palindrome partitioning of s.
    A palindrome string is a string that reads the same backward as forward.
    Input: s = "aab"
    Output: [["a","a","b"],["aa","b"]]
    
    Start from index 0. then generate valid substrings from index 0. i.e 1..2 1...3 ... 1...n
    everytime u find a palindrome ending at i, means u can partition it there, then we look
    for another palindrome that starts from i + 1 (in the same list)
    
    palidrome: a bb a. if char at index 1 and index end is the same, it is a palindrome if the
    characters in the middle is a palindrome, so we have a memo for it.
    */
    
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] memo = new boolean[s.length()][s.length()];
        search(0, s, ans, new ArrayList<String>(), memo);
        return ans;
        
    }
    
    public void search(int start, String s, List<List<String>> ans, List<String> partition, boolean[][] memo) {
        if (start >= s.length()) {
            ans.add(new ArrayList<>(partition));
            return;
        }
        //i is the end
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(start) == s.charAt(i) && (i - start <= 2 || memo[start + 1][i - 1])) {
                memo[start][i] = true;
                partition.add(s.substring(start, i + 1));
                search(i + 1, s, ans, partition, memo);
                partition.remove(partition.size() - 1); //remove all elements in the list before going to the next loop
            }
        } 
    }
}