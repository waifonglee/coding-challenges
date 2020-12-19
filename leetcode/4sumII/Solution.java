class Solution {
    /*
    Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there
    are such that A[i] + B[j] + C[k] + D[l] is zero.
    
    for every pair A[i] and B[j], store occurances of A[i] + B[j] in a hashmap. iterate 
    every possible value of C and D and check if the -1 * (c + d) is in the map. 
    O(n^2) space and time
    */
    
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < B.length; j ++) {
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        
        int num = 0;
        
        for (int k = 0; k < C.length; k ++) {
            for (int p = 0; p < D.length; p ++) {
                num += map.getOrDefault(-1*(C[k] + D[p]), 0); 
            }
        }
        return num;
    }
}