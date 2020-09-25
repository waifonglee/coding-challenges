import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Arrays.sort(ar);
        //System.out.println(Arrays.toString(ar));
        int num_of_pairs = 0;
        int current = ar[0];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (ar[i] == current) {
                count ++;
                //System.out.println("current =" + ar[i] + " " + count);
            } else {
                num_of_pairs = num_of_pairs + count / 2;
                //System.out.println("current pairs =" + num_of_pairs);
                count = 1;
                current = ar[i];
            }
        }
        return num_of_pairs + count / 2;

    }
    //space O(1) time O(2n)?

    public static void main(String[] args) throws IOException {
        int[] ar = new int[]{10,1,1,3,1,2,1,3,3,3,3};
        int result = sockMerchant(10, ar);
        System.out.println("result = " + result);
    }
}

/*
hashset method
Set<Integer> colors = new HashSet<>();
    int pairs = 0;

    for (int i = 0; i < n; i++) {
        if (!colors.contains(c[i])) {
            colors.add(c[i]);
        } else {
            pairs++;
            colors.remove(c[i]);
        }
    }

    System.out.println(pairs);
    
    space O(n) time O(n)
*/
