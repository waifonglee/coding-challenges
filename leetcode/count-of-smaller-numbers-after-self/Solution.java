class Solution {
    /*
    You are given an integer array nums and you have to return a new counts array.
    The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
    
    
    Use the process of mergesort to calculate the number of elements smaller than i to the right of it
    since mergesort is stable (the index of elements evaluated is unchanged)
    */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        if (nums.length == 0) {
            return ans;
        }
        
        Element[] elements = new Element[nums.length];
        for (int i = 0; i < nums.length; i++) {
            elements[i] = new Element(nums[i], i);
        }
        
        int[] res = new int[nums.length];
        
        mergesort(elements, res, 0, nums.length - 1);
        
        for (Integer i: res) {
            ans.add(i);
        }
        return ans;
        
    }
    
    public void mergesort(Element[] elements, int[] res, int start, int end) {
        if (end <= start) {
            return;
        }
        
        int mid = (end + start) / 2;
        mergesort(elements, res, start, mid);
        mergesort(elements, res, mid + 1, end);
        
        
        int left = start;
        int right = mid + 1;
        int lessThanLeft = 0;
        List<Element> merged = new ArrayList<Element>();
        
        while (left <= mid && right <= end) {
            if (elements[left].val > elements[right].val) {
                lessThanLeft ++;
                merged.add(elements[right]);
                right ++;
            } else {
                res[elements[left].index] += lessThanLeft;
                merged.add(elements[left]);
                left ++;
            }
            
        }
        
        while (left <= mid) {
            res[elements[left].index] += lessThanLeft;
            merged.add(elements[left]);
            left ++;
        }
        
        while (right <= end) {
            merged.add(elements[right]);
            right ++;
        }
        
        int j = start;
        for (Element e: merged) {
            elements[j] = e;
            j ++;
        }
        
    }
    
    class Element {
        public int val;
        public int index;
        
        public Element(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}