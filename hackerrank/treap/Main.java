import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) {
        Node node = new Node(1, 100);
        Node node2 = node.add(2, 200);
        Node node3 = node2.add(3,300);
        Node node4 = node3.add(4,400);
        node.add(5,500);
        System.out.println(node4);
        //System.out.println(node.get_index(2));
        //System.out.println(node);

    }
}