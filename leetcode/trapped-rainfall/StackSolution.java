class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        if (height.length < 3) {
            return area;
        }
        for (int i = 0; i < height.length; i ++) {
            while (stack.size() > 1 && height[i] > height[stack.peek()]) {
                int mid = height[stack.pop()];
                int shorterBound = Math.min(height[stack.peek()], height[i]);
                if (shorterBound >= mid) {
                    area += (shorterBound - mid) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return area;
    }
}
//slower than using pointers
