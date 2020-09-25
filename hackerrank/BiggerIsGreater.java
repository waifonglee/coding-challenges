import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;


public class BiggerIsGreater {
     // Complete the biggerIsGreater function below.
     static String biggerIsGreater(String w) {
        //find longest non increasing suffix
        if (w.length() == 1) {
            return "no answer";
        }

        int suffix_start = w.length() - 1;
        for (int i = w.length() - 2; i >= 0; i --) {
            if (w.charAt(i) < w.charAt(i + 1)) {
                break;
            } else {
                suffix_start --;
            }
        }

        if (suffix_start == 0) {
            return "no answer";
        }

        //find successor and swap
        Character successor = w.charAt(suffix_start);
        int ind_min_suffix = suffix_start;
        for (int k = suffix_start + 1; k < w.length(); k ++) {
            if (w.charAt(k) <= successor && w.charAt(k) > w.charAt(suffix_start - 1)) {
                ind_min_suffix = k;
                successor = w.charAt(ind_min_suffix);
            }
        }

        //swap
        StringBuilder res = new StringBuilder(w);
        res.setCharAt(ind_min_suffix, w.charAt(suffix_start - 1));
        res.setCharAt(suffix_start - 1, successor);

        //reverse
        int start = suffix_start;
        int end = w.length() - 1;
        while (start < end) {
            Character end_char = res.charAt(end);
            Character start_char = res.charAt(start);
            System.out.println(start);
            res.setCharAt(start, end_char);
            res.setCharAt(end, start_char);
            start++;
            end--;
        }

        return res.toString();

    }


    public static void main(String[] args) throws IOException {
        String ans = biggerIsGreater("abdc");
        System.out.println(ans);
    }
}
// See : https://www.nayuki.io/page/next-lexicographical-permutation-algorithm