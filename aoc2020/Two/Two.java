import java.util.*;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors


public class Two {
    static List<String> lines = new ArrayList<>();
    static int valid = 0;

    public static void scanLines() {
        try {
            File input = new File("two.txt");
            Scanner sc = new Scanner(input);
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }
            sc.close();
          } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
          }
    }

    public static String[] breakInstr(String s) {
        String[] ins = new String[4];
        String[] splitSpace = s.split(" ");
        String[] indexes = splitSpace[0].split("-");
        ins[0] = indexes[0];
        ins[1] = indexes[1];
        ins[2] = splitSpace[1].substring(0,1);
        ins[3] = splitSpace[2];
        return ins;
    }

    public static void opOne() {
        for (String line:lines) {
            String[] ins = breakInstr(line);
            int min = Integer.parseInt(ins[0]);
            int max = Integer.parseInt(ins[1]);
            //System.out.println(ins[0] + " " + ins[1] + " " + ins[2] + " " + ins[3]);
            long count = ins[3].chars().filter(c -> c == ins[2].charAt(0)).count();
            //System.out.println(count);
            if (count >= min && count <= max) {
                valid ++;
            }
        }

    }

    public static void opTwo() {
        for (String line:lines) {
            String[] ins = breakInstr(line);
            int first = Integer.parseInt(ins[0]);
            int second = Integer.parseInt(ins[1]);
            int c = ins[2].charAt(0);
            String pw = ins[3];
            int count = 0;
            
            if (pw.charAt(first - 1) == c) {
                count ++;
            }

            if (pw.charAt(second - 1) == c) {
                count ++;
            }

            if (count == 1) {
                valid ++;
            }
        }

    }

    public static void main(String[] args) {
        scanLines();
        opTwo();
        System.out.println(valid);
    }
}
