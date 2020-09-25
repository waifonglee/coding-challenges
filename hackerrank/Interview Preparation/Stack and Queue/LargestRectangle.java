import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LargestRectangle {
    static long largestRectangle(int[] h) {
        int[] start_arr = new int[h.length];
        Stack<Integer> s = new Stack<Integer>();
        long area = 0;

        for (int i = 0; i < h.length; i++) {
            if (s.empty() || h[s.peek()] < h[i]) {
                s.push(i);
                start_arr[i] = i;
            } else {
                while (!s.empty()) {
                    if (h[s.peek()] >= h[i]) {
                        int pop = s.pop();
                        area = Math.max(area, (i - start_arr[pop]) * h[pop]);
                        start_arr[i] = start_arr[pop];
                    } else {
                        area = Math.max(area, (i - start_arr[i] + 1) * h[i]);
                        s.push(i);
                        break;
                    }
                }
                if (s.empty()) {
                    start_arr[i] = 0;
                    s.push(i);
                    area = Math.max(area, (i + 1) * h[i]);
                }
            }
        }
        while (!s.empty()) {
            int pop = s.pop();
            int calc = (h.length - start_arr[pop]) * h[pop];
            area = Math.max(area, calc); 
            System.out.println("popped = " + pop);
            System.out.println("calc = " + calc);
            System.out.println("area = " + area);
        }

        System.out.println(area);
        return area;
        
    }

    public static void main(String[] args) throws IOException {
        int[] arr = new int[]{1,2,3,4,5};
        largestRectangle(arr);
    }
}