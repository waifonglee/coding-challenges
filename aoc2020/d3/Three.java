package aoc2020.d3;
import java.util.*;
import java.math.BigInteger; 
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors

public class Three {
    static String[] map = new String[323];
    static int LENGTH_Y = 323;
    static int LENGTH_X = 31; 
    static char SQUARE = '.';
    static char TREE = '#';

    public static void scanLines() {
        try {
            File input = new File("three.txt");
            Scanner sc = new Scanner(input);
            int i = 0;
            while (sc.hasNextLine()) {
                map[i] = sc.nextLine();
                i++;
            }

            sc.close();
          } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
          }
    }

    public static int op(int right, int down) {
        int posX = 0;
        int posY = 0;
        int trees = 0;
        while (posY < LENGTH_Y) {
            char item = map[posY].charAt(posX);
            if (item == TREE) {
                trees++;
            }
            posX = (posX + right) % LENGTH_X;
            posY = posY + down;
        }

        return trees;
    }

    public static void main(String[] args) {
        scanLines();
        int threeOne = op(3, 1);
        System.out.println(threeOne);
        
        int oneOne = op(1, 1);
        System.out.println(oneOne);

        int fiveOne = op(5, 1);
        System.out.println(fiveOne);

        int sevenOne = op(7, 1);
        System.out.println(sevenOne);

        int oneTwo = op(1, 2);
        System.out.println(oneTwo);

        BigInteger mult = new BigInteger("1");
        mult = mult.multiply(BigInteger.valueOf(threeOne));
        mult = mult.multiply(BigInteger.valueOf(oneOne));
        mult = mult.multiply(BigInteger.valueOf(fiveOne));
        mult = mult.multiply(BigInteger.valueOf(sevenOne));
        mult = mult.multiply(BigInteger.valueOf(oneTwo));
        System.out.println(mult.toString());
    }
}
