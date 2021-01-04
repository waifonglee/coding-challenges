class Solution {
    /*
    A city's skyline is the outer contour of the silhouette formed by all the buildings in that city 
    when viewed from a distance. Given the locations and heights of all the buildings, 
    return the skyline formed by these buildings collectively.
    
    The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:

    lefti is the x coordinate of the left edge of the ith building.
    righti is the x coordinate of the right edge of the ith building.
    heighti is the height of the ith building.
    You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

    he skyline should be represented as a list of "key points" sorted by their x-coordinate in the form [[x1,y1],[x2,y2],...].
    Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list, 
    which always has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost building ends. 
    Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.
    
    Note: There must be no consecutive horizontal lines of equal height in the output skyline. 
    For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable
    the three lines of height 5 should be merged into one in the final output as such: [...,[2 3],[4 5],[12 7],...]
    */
    
    //merged intervals of 2D
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        
        for (int[] p: buildings) {
            heights.add(new int[] {p[0], -p[2]}); // start point
            heights.add(new int[] {p[1], p[2]}); // end point
        }

        Collections.sort(heights, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        //if same start/end points, sort by height. if different, sort by start/end points
        //start heights are negative !!!!
        /* 
        3 Cases from the sorting:
        1. same start points. the taller one will be first
        2. same end points. the shorter one will be first
        3. same start & end point of 2 different building: the start point's height will be first
        */

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.add(0);
        int currMax = 0;
        for (int[] h: heights) {
            if (h[1] < 0) {
                pq.add(-h[1]);
            } else {
                pq.remove(h[1]);
            }

            if (pq.peek() != currMax) {
                currMax = pq.peek();
                List<Integer> r = new ArrayList<>();
                r.add(h[0]);
                r.add(currMax);
                ans.add(r);
            }
            
        }
        return ans;

    }
}