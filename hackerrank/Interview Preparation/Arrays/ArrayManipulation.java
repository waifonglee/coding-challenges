import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        //record rate of change O(n) space, O(n+m) time
        long max = 0;
        long[] arr = new long[n + 2];
        for (int i = 0; i < queries.length; i ++) {
            int[] current_query = queries[i];
            arr[current_query[0]] = arr[current_query[0]] + current_query[2];
            arr[current_query[1] + 1] = arr[current_query[1] + 1] - current_query[2];
        }

        long current_val = 0;
        for (int j = 1; j < n + 1; j ++) {
            if (arr[j] != 0) {
                if (arr[j] != 0) {
                    current_val += arr[j];
                    max = Math.max(max, current_val);
                }
            }
        }
        return max;
    }
    
    /* 
    solution below is too slow

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        int[] arr = new int[n];
        long max = 0;
        int no_queries = queries.length;
        for (int i = 0; i < no_queries; i ++) {
            int[] current_query = queries[i];
            int start_ind = current_query[0] - 1;
            int end_ind = current_query[1] - 1;
            int add = current_query[2];
            for (int j = start_ind; j < end_ind + 1; j++) {
                arr[j] = arr[j] + add;
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
        }
        return max;
    }
    */
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}