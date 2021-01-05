/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
    Given the root of a binary tree, determine if it is a valid binary search tree (BST).

    A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
    
    need to compare max of left and min of right to check.
    
    */
    
    HashMap<TreeNode, Integer> max;
    HashMap<TreeNode, Integer> min;
    public boolean isValidBST(TreeNode root) {
        max = new HashMap<TreeNode, Integer>();
        min = new HashMap<TreeNode, Integer>();
        return isValid(root);
    }
    
    public boolean isValid(TreeNode root) {
        if (root.left == null && root.right == null) {
            max.put(root, root.val);
            min.put(root, root.val);
            return true;
        }
        
        if (root.right != null) {
            boolean right = isValid(root.right);
            if (!right || min.get(root.right) <= root.val) {
                return false;
            }
            max.put(root, max.get(root.right));
            
        }
        
        if (root.left != null) {
            boolean left = isValid(root.left);
            if (!left || max.get(root.left) >= root.val) {
                return false;
            }
            min.put(root, min.get(root.left));
        }
        
        if (!max.containsKey(root)) {
            max.put(root, root.val);
        }
        
        if (!min.containsKey(root)) {
            min.put(root, root.val);
        }
        
        return true;
    }
}

/*
use inorder traversal faster O(n)
left, root , right. make sure its increasing. if its not then return false.
*/
Integer prev; //Integer to support null value
public boolean isValidBST(TreeNode root) {
    prev = null;
    return inorder(root);
}

public boolean inorder(TreeNode root) {
    if (root == null) {
        return true;
    }

    boolean left = inorder(root.left);
    if (!left) {
        return false;
    }
    if (prev != null && root.val <= prev) {
        return false;
    }

    prev = root.val;

    return inorder(root.right); //this way, if the right tree is a null, the prev val remains to be the root
}