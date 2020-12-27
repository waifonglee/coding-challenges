class Solution {
    /*
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
    and return an array of the non-overlapping intervals that cover all the intervals in the input.
    
    sort the intervals then iterate.
    */
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        if (intervals.length == 1) {
            return intervals;
        }
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i ++) {
            if (intervals[i][0] > currentEnd) {
                ans.add(new int[]{currentStart, currentEnd});
                currentStart = intervals[i][0];
                currentEnd = intervals[i][1];
            } else {
                currentEnd = Math.max(currentEnd,intervals[i][1]);
            }
        }
        ans.add(new int[]{currentStart, currentEnd});
        int[][] ansArr = new int[ans.size()][2];
        return ans.toArray(ansArr);
    }
}