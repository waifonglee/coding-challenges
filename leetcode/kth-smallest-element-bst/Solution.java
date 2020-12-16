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
//Given a binary search tree, write a function kth Smallest to find the kth smallest element in it.
//Perform in order traversal . O(n) space. if keep track of nodes processed,  O(1) space
class Solution {
    int processed = 0;
    int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        inOrderTr(root, k);
        return ans;
    }
    
    public void inOrderTr(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inOrderTr(root.left, k);
        if (ans != -1) {
            return;
        }
        
        processed++;
        if (processed == k) {
            ans = root.val;
            return;
        }
        inOrderTr(root.right, k);
    }
}