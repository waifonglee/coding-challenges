import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int valleys = 0;
        int level = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'D') {
                level--;
                System.out.println("at downhill " + level);
                if (level == -1) {
                    valleys ++;
                }
                
            } else {
                level++;
                System.out.println("at uphill " + level);
            }
        }
        return valleys;
    }

    public static void main(String[] args) throws IOException {
      
        int result = countingValleys(8, "UDDDUDUU");
        System.out.println("result = " + result);
    }
}