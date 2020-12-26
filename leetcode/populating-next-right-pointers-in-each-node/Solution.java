/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    /*
    You are given a perfect binary tree where all leaves are on the same level, and every parent has two
    children. 
    Populate each next pointer to point to its next right node. If there is no next right node, the next
    pointer should be set to NULL.
    Initially, all next pointers are set to NULL.
    
    
    in each recursive call: 
    connect left tree to right tree. connect right tree to left tree of node's next pointer
    */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        root.next = null;
        connectHelper(root);
        return root;
        
    }
    public void connectHelper(Node root) {
        if (root.left == null) {
            return;
        }
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        } else {
            root.right.next = null;
        }
        
        connectHelper(root.left);
        connectHelper(root.right);
    }
}