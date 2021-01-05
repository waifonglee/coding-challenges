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
 
 
    Given a non-empty binary tree, find the maximum path sum.
    For this problem, a path is defined as any node sequence from some starting node to any node in the tree
    along the parent-child connections. 
    The path must contain at least one node and does not need to go through the root.

    2 situations:
    From the root:
    1. the path continues going up. hence we cannot add both subtrees. get max of left/right and add root
    2. the path includes left + right subtrees. add left + right + root. but it cannot go up from the root.
 */
class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxToRoot(root);
        return max;
    }
    
    public int maxToRoot(TreeNode node) { //returns val of case 1
        if (node == null) {
            return 0;
        }
        
        int left = Math.max(0, maxToRoot(node.left)); //Math.max to deal with negative values so we dont have to if/else it
        int right = Math.max(0, maxToRoot(node.right));
        max = Math.max(max, left + right + node.val); //deal with case 2 & if any node is negative, it becomes 0 in the prev lines hence we only end up counting the non negative nodes.
        return Math.max(left, right) + node.val;
    }
    
    
}