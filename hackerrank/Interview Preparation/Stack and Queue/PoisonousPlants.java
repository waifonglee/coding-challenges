import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class PoisonousPlants {
    
    public static class PlantQ {
        PlantQ next;
        int poison;

        PlantQ(int poison) {
            this.poison = poison;
        }

        public void printAll() {
            PlantQ current = this;
            while (current != null) {
                System.out.print(current.poison + "->");
                current = current.next;
            }
            System.out.print("\n");
        }
    }
    
    
    public static class ListNode {
        PlantQ start;
        PlantQ end;
        ListNode next;
        ListNode prev;
        
        ListNode(PlantQ start, PlantQ end) {
            this.start = start;
            this.end = end;
        }
        
        ListNode() {}
         
        public void printAll() {
            ListNode current = this;
            while (current != null) {
                System.out.println("current = ");
                current.start.printAll();
                if (current.prev!=null) {
                    System.out.println("prev = ");
                    current.prev.start.printAll();
                }
                if (current.next!=null) {
                    System.out.println("next = ");
                    current.next.start.printAll();
                }
                current = current.next;
            }   
        }
    }

    static ListNode initialize(int[] p) {
        PlantQ q = new PlantQ(p[0]);
        ListNode plants = new ListNode(q, q);
        ListNode current_node = plants;
        
        for (int i = 1; i < p.length; i++) {
            if (p[i] <= current_node.end.poison) {
                PlantQ toAdd = new PlantQ(p[i]);
                current_node.end.next = toAdd;
                current_node.end = toAdd;
            } else {
                PlantQ toAdd = new PlantQ(p[i]);
                current_node.next = new ListNode(toAdd, toAdd);
                current_node.next.prev = current_node;
                current_node = current_node.next;
            }
        }
        return plants;
    }

    // Complete the poisonousPlants function below.
    static int poisonousPlants(int[] p) {
        ListNode plants = initialize(p);
        //plants.printAll(); 
        
        ListNode current_node = plants;
        int days = 0;
        while (plants.next != null) {
            if (current_node == plants) {
                days++;
                current_node = plants.next;
            } else if (current_node == null) {
                current_node = plants;
            } else if (current_node.start  == current_node.end) {
                if (current_node.prev != null) {
                    current_node.prev.next = current_node.next;
                }
                if (current_node.next != null) {
                    current_node.next.prev = current_node.prev;
                }
                current_node = current_node.next;
            } else {
                PlantQ curr_start = current_node.start;
                current_node.start = curr_start.next;
                if (current_node.start.poison <= current_node.prev.end.poison) { //check if can merge
                    current_node.prev.end.next = current_node.start; //remove head of queue
                    current_node.prev.end = current_node.end; 
                    current_node.prev.next = current_node.next;
                    if (current_node.next != null) {
                        current_node.next.prev = current_node.prev;
                    }
                }
                current_node = current_node.next;
            }
            //System.out.println("Iteration \n days = " + days);
            //plants.printAll();
        }
        
        return days;
    }

    public static void main(String[] args) throws IOException {
        int[] p = new int[]{1,1,1,5};
        poisonousPlants(p);
    }
}

/* 
    solution below only passes some test case
    // Complete the poisonousPlants function below.
    static int poisonousPlants(int[] p) {
        Stack<Integer> stack = new Stack<Integer>();
        int max_days = 0;
        int days = 0;
        int min_poison = p[0];
        for (int i = 1; i < p.length; i++) {
            if (p[i] <= min_poison) {
                if (stack.isEmpty()) {
                    min_poison = p[i];
                } else {
                    max_days = Math.max(max_days, days);
                    min_poison = p[i];
                    days = 0;
                    stack.pop();
                } 
            } else {
                if (stack.isEmpty()) {
                    days++;
                    stack.push(p[i]);
                } else {
                    if (p[i] >= stack.peek()) {
                        stack.pop();
                        stack.push(p[i]);
                    } else {
                        stack.pop();
                        stack.push(p[i]);
                        days++;
                    }
                }
            }
        }
        return Math.max(max_days, days);
    }
    */
