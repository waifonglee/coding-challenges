import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;

class ClimbingTheLeaderboard {
    
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] res = new int[alice.length];
        Stack<Integer> s = new Stack<Integer>();
        
        for (int i = 0; i < scores.length; i++) {
            if (s.empty()) {
                s.push(scores[i]);
            } else {
                if (s.peek() == scores[i]) {
                    continue;
                } else {
                    s.push(scores[i]);
                }
            }
        }
        
        for (int j = 0; j < alice.length; j ++) {
            if (s.isEmpty()) {
                res[j] = 1;
            } else {
                if (alice[j] >= s.peek()) {
                    while (!s.isEmpty() && alice[j] >= s.peek()) {
                        s.pop();
                    }
                }
                res[j] = s.size() + 1;
            }
        }

        System.out.println(res);
        return res;
    }


    public static void main(String[] args) throws IOException {
        int[] scores = new int[]{100, 90, 90, 80, 75, 60};
        int[] alice = new int[]{50, 65, 77, 90, 102};
        climbingLeaderboard(scores, alice);
    }
}