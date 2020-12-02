import java.util.*;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors

class One {
    public static void partOne() {
        int TOTAL = 2020;
        HashSet<Integer> set = new HashSet<>();
        try {
            File input = new File("one.txt");
            Scanner sc = new Scanner(input);
            while (sc.hasNextLine()) {
                int data = sc.nextInt();
                if (set.contains(TOTAL - data)) {
                    System.out.println(data * (TOTAL - data));
                    break;
                } else {
                    set.add(data);
                }
              
            }
            sc.close();
          } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
          }
    }

    public static int[] scanInt() {
        int[] arr = new int[200];
        try {
            File input = new File("one.txt");
            Scanner sc = new Scanner(input);
            int i = 0;
            while (sc.hasNextLine()) {
                arr[i] = sc.nextInt();
                i++;
            } 
            sc.close();
          } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
          }
          return arr;
    }

    public static void partTwo() {
        int TOTAL = 2020;
        int[] arr = scanInt();
        Arrays.sort(arr); 
        boolean solved = false;
        
        for (int i = 0; i + 2 < arr.length; i++) {
            if (solved) {
                break;
            }

            if (arr[i] == 0) {
                continue;
            }

            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = arr.length - 1;
            int remainder = TOTAL - arr[i];
            while (j < k) {
                int sum = arr[j] + arr[k];
                
                if (sum == remainder) {
                    solved = true;
                    System.out.println(arr[j] * arr[k] * arr[i]);
                    break;
                }
                
                if (sum > remainder) {
                    k--;
                } else {
                    j++;
                }
            }
        }
    }
    

    public static void main(String[] args) {
        partTwo();
    }
}