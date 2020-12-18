class Solution {
    /*
    Given a n x n matrix where each of the rows and columns are sorted in ascending order,
    find the kth smallest element in the matrix.
    
    Note that it is the kth smallest element in the sorted order, not the kth distinct element.
    
    add elements from row 0 into pq. everytime we poll, we add the element from same col but + 1 the row into pq. (draw it out to understand it better). only add in elements that could possibly be smaller than element polled
    */
    
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Element> q = new PriorityQueue<>(k, 
                                    (x, y) -> Integer.compare(x.val, y.val)); 
        int count = 0;
        int smallest = matrix[0][0];
        
        for (int i = 0; i < matrix[0].length; i ++ ) {
            q.offer(new Element(matrix[0][i], 0, i));
        }
        
        while (count < k) {  
            Element curr = q.poll();
            smallest = curr.val;
            count ++;
            if (curr.r == matrix.length - 1) {
                continue;
            }
            q.offer(new Element(matrix[curr.r + 1][curr.c], curr.r + 1, curr.c));
        }
        return smallest;
    }
    
    class Element {
        int val;
        int r;
        int c;
        
        public Element(int val, int r, int c) {
            this.val = val;
            this.r = r;
            this.c = c;
        }
    }
}