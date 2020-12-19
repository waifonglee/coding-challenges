class Solution {
    /*
    There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
    Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
    which is expressed as a pair: [0,1]
    Given the total number of courses and a list of prerequisite pairs, 
    is it possible for you to finish all courses?
    
    Cycle detection
    Topological sort
    
    i think just detecting cycle directly will be faster than topo sorting, but idk
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        int[] indeg = new int[numCourses];
        
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
        return canFinish == numCourses;
    }
}