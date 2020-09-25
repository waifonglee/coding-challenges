import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class CastleOnTheGrid {
    
    static int get_min(String[] grid, int prevX, int prevY, int startX, int startY, int goalX, int goalY, int moves) {
        if (startX == goalX && startY == goalY) {
            return moves + 1;
        } else if (startY >= grid.length || startX >= grid[0].length() || startY < 0 || startX < 0) {
            return Integer.MAX_VALUE;
        } else if (grid[startY].charAt(startX) == 'X') {
            return Integer.MAX_VALUE;
        } else {
            int x_inc = get_min(grid, startX, startY, startX + 1, startY, goalX, goalY, moves + 1);
            int y_inc = get_min(grid, startX, startY, startX, startY + 1, goalX, goalY, moves + 1);
            int x_dec = get_min(grid, startX, startY, startX - 1, startY, goalX, goalY, moves + 1);
            int y_dec = get_min(grid, startX, startY, startX, startY - 1, goalX, goalY, moves + 1);
            
            if (startX + 1 == prevX && startY == prevY) {
                x_inc = Integer.MAX_VALUE;
            }

            if (startX - 1 == prevX && startY == prevY) {
                x_dec = Integer.MAX_VALUE;
            }

            if (startX == prevX && startY + 1 == prevY) {
                y_inc = Integer.MAX_VALUE;
            }

            if (startX == prevX && startY - 1 == prevY) {
                y_dec = Integer.MAX_VALUE;
            }
            
            return Math.min(Math.min(x_inc, x_dec), Math.min(y_inc, y_dec));
        }
    }

    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        /*
        int x = startX;
        int y = startY;
        Stack<Integer> stack_x = new Stack<Integer>();
        stack_x.push(x);
        Stack<Integer> stack_y = new Stack<Integer>();
        stack_y.push(y);
        */

        int x_inc = get_min(grid, startX, startY, startX + 1, startY, goalX, goalY, 0);
        int y_inc = get_min(grid, startX, startY, startX, startY + 1, goalX, goalY, 0);
        int x_dec = get_min(grid, startX, startY, startX - 1, startY, goalX, goalY, 0);
        int y_dec = get_min(grid, startX, startY, startX, startY - 1, goalX, goalY, 0);
        
        return Math.min(Math.min(x_inc, x_dec), Math.min(y_inc, y_dec));
    
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
