import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long quotient = n / s.length();
        long remainder = n - (quotient * s.length());
        long count_in_remainder = 0;
        long count_in_string = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                if (i < remainder) {
                    count_in_remainder ++;
                }
                count_in_string++;
            }
        }
        return quotient * count_in_string + count_in_remainder;

    }

    public static void main(String[] args) throws IOException {
        long result = repeatedString("aba",10);
        System.out.println("result = " + result);

    }
}
