class Solution {
    /*
    We have two integer sequences A and B of the same non-zero length.

    We are allowed to swap elements A[i] and B[i].  
    Note that both elements are in the same index position in their respective sequences.
    
    At the end of some number of swaps, A and B are both strictly increasing.  
    (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)
    
    Given A and B, return the minimum number of swaps to make both sequences strictly increasing.  
    It is guaranteed that the given input always makes it possible.
    */
    public int minSwap(int[] A, int[] B) {
        int prevSwap = 1;
        int prevNotSwap = 0;
        
        for (int i = 1; i < A.length; i ++) {
            int swap = 0;
            int dontSwap = 0;
            if (A[i] > A[i - 1] && B[i] > B[i - 1] && A[i] > B[i - 1] && B[i] > A[i - 1]) {
                swap = Math.min(prevSwap, prevNotSwap) + 1;
                dontSwap = Math.min(prevSwap, prevNotSwap);
                
            } else if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                dontSwap = prevNotSwap;
                swap = prevSwap + 1;
            } else if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                dontSwap = prevSwap;
                swap = prevNotSwap + 1;
            }
            prevSwap = swap;
            prevNotSwap = dontSwap;
            
        }
        return Math.min(prevSwap, prevNotSwap);
    }
}