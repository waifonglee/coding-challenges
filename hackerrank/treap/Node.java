import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;



public class Node {
    int val;
    int priority;
    int key;
    int size; //size of left & right children + this node
    Node left;
    Node right;
    Random rdm = new Random();

    public Node(int key, int val, int priority, Node left, Node right, int size) {
        this.key = key;
        this.val = val;
        this.priority = priority;
        this.left = left;
        this.right = right;
        this.size = size;
    }

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.priority = rdm.nextInt(100000001);
        this.right = null;
        this.left = null;
        this.size = 1;
    }

    public Node() { //default values
        this(0, 0);
    }

    private Node left_rotate(Node root) {
        Node right_tree = root.right;
        root.right = right_tree.left;
        right_tree.left = root;

        root.update_size();
        right_tree.update_size();

        return right_tree;
    }

    private Node right_rotate(Node root) {
        Node left_tree = root.left;
        root.left = left_tree.right;
        left_tree.right = root;

        root.update_size();
        left_tree.update_size();

        return left_tree;
    }

    public void update_size(){
        int left_size = this.left != null ? this.left.size : 0;
        int right_size = this.right != null ? this.right.size : 0;

        this.size = left_size + right_size + 1;
    }

    public Node merge(Node left, Node right) { //already assume all key values in left tree < right tree
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        Node new_node = null;

        if (left.priority > right.priority) {
            Node new_right = merge(left.right, right);
            new_node = new Node(left.key, left.val, left.priority, left.left, new_right, 1);

        } else {
            Node new_left = merge(left, right.left);
            new_node = new Node(right.key, right.val, right.priority, new_left, right.right, 1);

        }

        new_node.update_size();
        return new_node;
    }

    public Node[] split(boolean implicit_index, Node root, int in_key, int in_val, int index) {
        Node[] res_tree = new Node[]{null, null};

        if (root == null) {
            return res_tree;
        }
        
        //calculate size of left subtree for implicit indexing
        int left_size = this.left != null ? this.left.size : 0;
        int current_key = 0;

        boolean result;
        
        if (implicit_index) {
            current_key = left_size + index;
            result = current_key <= key;

        } else {
            result = this.key <= key;
        }

        //is key in current node smaller than the key being passed in? 
        //if so we add this node to the left tree and split along the right
        if (result) {
            res_tree = split(implicit_index, this.right, in_key, in_val, current_key + 1);
            this.right = res_tree[0];
            res_tree[0] = this;
        
        } else {

            res_tree = split(implicit_index, this.left, in_key, in_val, index);
            this.left = res_tree[1];
            res_tree[1] = this;

        }

        if (res_tree[0] != null) {
            res_tree[0].update_size();
        }

        if (res_tree[1] != null) {
            res_tree[1].update_size();
        }
        
        return res_tree;
    }

    
    public Node add(int in_key, int in_val) {
        Node[] split_ed = split(false, this, in_key, in_val, 0);
        Node to_add = new Node(in_key, in_val);

        return merge(merge(split_ed[0], to_add), split_ed[1]);
    }

    public Node get_index(int index) { //1 based index (first element in tree is position 1)
        Node found = null;

        if (this == null) {
            return found;
        } else {
            int left_size = this.left != null ? this.left.size : 0;
            
            if (index < left_size) {
                found = this.left.get_index(index);                
            
            } else if (this.left == null && index == 0) {
                found = this;
            
            } else if (index == left_size) {
                found = this;
            
            } else {
                found = this.right.get_index(index - (left_size + 1));
            
            }
        }
        return found;
    }

    public Node delete(int key) {  
        Node root = null;

        if (this == null) {
            return null;
        }

        if (key < this.key) {
            Node new_left = this.left.delete(key);
            this.left = new_left;
        } 

        if (key > this.key) {
            Node new_right = this.right.delete(key);
            this.right = new_right;
        }

        if (key == this.key) {
            if (this.left != null && this.right != null) {
                if (this.left.priority < this.right.priority) {
                    root = this.right_rotate(this);

                } else {
                    root = this.left_rotate(this);
                }

            } else if (this.left != null) {
                root = this.right_rotate(this);
            
            } else if (this.right != null) {
                root = this.left_rotate(this);
            
            } else {
                return null;
            }
            
            root = root.delete(key);
        }

        root.update_size();
        return root;
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < this.size; i ++) {
            string = string + this.get_index(i).val + "\n";
        }
        return string;
    }

}
