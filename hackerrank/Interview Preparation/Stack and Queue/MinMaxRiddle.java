import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinMaxRiddle { //extension of largest rectangle problem
    
    // Complete the riddle function below.
    static long[] riddle(long[] arr) {
        // complete this function
        int[] start_arr = new int[arr.length]; //start counting window length for a[i]
        int[] window = new int[arr.length]; //max window size where its min
        Stack<Integer> s = new Stack<Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (s.empty() || arr[s.peek()] < arr[i]) {
                s.push(i);
                start_arr[i] = i;
            } else {
                while (!s.empty()) {
                    if (arr[s.peek()] >= arr[i]) {
                        int pop = s.pop();
                        start_arr[i] = start_arr[pop];
                        window[pop] = i - start_arr[pop];
                    } else {
                        window[i] = i - start_arr[i] + 1;
                        s.push(i);
                        break;
                    }
                }
                if (s.empty()) {
                    start_arr[i] = 0;
                    window[i] = i + 1;
                    s.push(i);
                }
            }
        }
        while (!s.empty()) {
            int pop = s.pop();
            window[pop] = arr.length - start_arr[pop];
        }

        long[] result = new long[arr.length]; 
        int window_size = 0;
        for (int k = 0; k < arr.length; k ++) {
            window_size = window[k];
            long curr_max = result[window_size - 1];
            result[window_size - 1] = Math.max(curr_max, arr[k]);
        }

        //some might be empty,
        //take maximum of window bigger than it, start from last one as the last one will always have answer
        for (int m = arr.length - 2; m > 0; m --) { 
            result[m] = Math.max(result[m], result[m + 1]);
        }
        

        
        /*
        for(int j = 0; j < arr.length; j++) {
            //System.out.println("Number " + arr[j] + " window = " + window[j]);
            System.out.println("window " + (j + 1) + " largest = " + result[j]);
        }
        */

        return result;
    }


    public static void main(String[] args) throws IOException {
        long[] arr = new long[]{789168277 ,694294362 ,532144299 ,20472621 ,316665904 ,59654039 ,685958445 ,925819184 ,371690486 ,285650353 ,522515445 ,624800694 ,396417773 ,467681822 ,964079876 ,355847868 ,424895284 ,50621903 ,728094833 ,535436067 ,221600465 ,832169804 ,641711594 ,518285605 ,235027997 ,904664230 ,223080251 ,337085579 ,5125280 ,448775176 ,831453463 ,550142629 ,822686012 ,555190916 ,911857735 ,144603739 ,751265137 ,274554418 ,450666269 ,984349810 ,716998518 ,949717950 ,313190920 ,600769443 ,140712186 ,218387168 ,416515873 ,194487510,149671312,241556542,575727819,873823206};
        riddle(arr);
    }
}