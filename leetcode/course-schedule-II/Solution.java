class Solution {
    /*
    There are a total of n courses you have to take labelled from 0 to n - 1.

    Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must
    take the course bi before the course ai.

    Given the total number of courses numCourses and a list of the prerequisite pairs, return the
    ordering of courses you should take to finish all courses.

    If there are many valid answers, return any of them. If it is impossible to finish all courses,
    return an empty array.

    */
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        int[] indeg = new int[numCourses];
        int[] lst = new int[numCourses];
        
        //i -> j, means must take i to take j
        for(int i = 0; i < prerequisites.length; i++) {
            int take = prerequisites[i][0];
            int pre = prerequisites[i][1];
            graph[pre][take] = 1;
            indeg[take] ++; //no need check for duplicates as there is none
        }
        
        int canFinish = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int k = 0; k < numCourses; k ++) {
            if (indeg[k] == 0) {
                q.offer(k);
            }
        }
        
        while (!q.isEmpty()) {
            int u = q.poll();
            lst[canFinish] = u;
            canFinish ++;
            for (int p = 0; p < graph[u].length; p ++) {
                if (indeg[p] > 0 && graph[u][p] > 0) {
                    indeg[p] --;
                }
                if (indeg[p] == 0 && graph[u][p] > 0) {
                    q.offer(p);
                }
            }
        }
        return canFinish == numCourses ? lst: new int[] {};
    }
}