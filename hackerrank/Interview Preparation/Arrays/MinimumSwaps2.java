import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    // Complete the minimumSwaps function below.
    // find path length of cycle - 1
    static int minimumSwaps(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            // case 1 : correct place & case 2 : count already
            if (arr[i] == i + 1 || arr[i] == -1 ) {
                continue;
            } else {
                //case 3 : need to swap
                int current_int = arr[i];
                int current_ind = i;
                while (arr[i] != -1) {
                    int temp = current_int - 1;
                    current_int = arr[temp];
                    arr[temp] = -1;
                    current_ind = temp;
                    count ++;
                }
                count --;
            }
        }
        return count;

    }

private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}