// Using stack, O(n). kinda like the rainfall one???

class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        
        Character current = null;
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            if (current == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        
        return max;            
    }
}