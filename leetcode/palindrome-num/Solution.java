class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            Deque<Integer> deque = new LinkedList<Integer>(); 
            int val = x;
            while (val >= 1) {
                deque.offer(val % 10);
                val = val / 10;
            }
            
            
            boolean ans = true;
            while (deque.size() > 1) {
                if (deque.pollFirst() != deque.pollLast()) {
                    ans = false;
                    break;
                }
            }
            
            return ans;
        }
    }
}

//solution is slow
/* faster way is to reverse half of the digits using  
int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        then compare with the first half
        */
