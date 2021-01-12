class Solution {
    /*
    Given two words beginWord and endWord, and a dictionary wordList, return the length of the
    shortest transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time.
    Each transformed word must exist in the word list.
    Return 0 if there is no such transformation sequence.
    
    BFS
    why not trie? because we need to remove the word at the end of each iteration of the search
    hard to remove from trie. hashset better
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        if (!words.contains(endWord)) {
            return 0;
        }
        int count = 1;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i ++) {
                char[] curr = q.poll().toCharArray();
                for (int j = 0; j < curr.length; j ++) {
                    char c = curr[j];
                    for (char x = 'a'; x <= 'z'; x ++) {
                        curr[j] = x;
                        String s = String.valueOf(curr);
                        if (words.contains(s)) {
                            if (s.equals(endWord)) {
                                count ++;
                                return count;
                            }
                            q.offer(s);
                            words.remove(s);
                        }
                        curr[j] = c;
                    }
                }
                
            }
            count ++;
        }
        
        return 0;   
    }
}