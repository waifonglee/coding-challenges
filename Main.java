import java.util.*;

public class Main {

    public static int[] clockwiseRotate(int[] coordinates, int deg){
        if (deg % 360 == 90){
            return new int[]{coordinates[1], -coordinates[0]};
        }
        if (deg % 360 == 180){
            return new int[]{-coordinates[0], -coordinates[1]};
        }        
        if (deg % 360 == 270) {
            return new int[]{-coordinates[1], coordinates[0]};
        }
        return coordinates;
    }
    
    
    public static int[] antiClockwiseRotate(int[] coordinates, int deg){
        return clockwiseRotate(coordinates, 360 - deg);
    }
    
      public static int countMoves(char[] moves) {
          int count = 0;
          HashSet<int[]> set = new HashSet<>();
          Deque<int[]> q = new LinkedList<>();
          int[] head = new int[]{1, 0};
          int[] tail = new int[]{0, 0};
          int[] facing = new int[]{1, 0};
          set.add(head);
          set.add(tail);
          q.add(head);
          q.add(tail);
    
          for (int i = 0; i < moves.length; i ++) {
              if (moves[i] == 'L') {
                  facing = antiClockwiseRotate(facing, 90);
              }
              if (moves[i] == 'R') {
                  facing = clockwiseRotate(facing, 90);
              }
              head = new int[]{head[0] + facing[0], head[1] + facing[1]};
              if (moves[i] != 'E') {
                  set.remove(tail);
                  q.pollLast();
                  tail = q.peekLast();
              }
              if (set.contains(head)) {
                count ++;  
                return count;
              } else {
                  set.add(head);
                  q.addFirst(head);
                  count ++;
              }
          }
    
          return -1;
      }
  public static void main(String [] args) {
    try {
      Scanner scan = new Scanner(System.in);
      int i = Integer.parseInt(scan.nextLine().trim());
      //System.out.println(i);
      for (int k = 0; k < i; k ++) {
        String string = scan.nextLine();
        char[] split = string.split(" ")[1].trim().toCharArray();
        /*
        int m = countMoves(split);
        if (m < 0) {
            System.out.println("YES");
        } else {
            System.out.println(m);
        }
        */
        System.out.println(string);
      }
    } catch (Exception e) {}
  }
}