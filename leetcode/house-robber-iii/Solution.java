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
    The thief has found himself a new place for his thievery again. 
    There is only one entrance to this area, called root.
    Besides the root, each house has one and only one parent house. 
    After a tour, the smart thief realized that all houses in this place form a binary tree. 
    It will automatically contact the police if two directly-linked houses were broken into on the same night.
    
    Given the root of the binary tree, 
    return the maximum amount of money the thief can rob without alerting the police.
    */
    HashMap<TreeNode, Integer> rob = new HashMap<>(); //start with node and rob
    HashMap<TreeNode, Integer> dontRob = new HashMap<>(); //start with node and dont rob
    public int rob(TreeNode root) {
        return Math.max(helper(root, true), helper(root,false));
    }
    
    public int helper(TreeNode node, boolean toRob) {
        if (node == null) {
            return 0;
        }
        
        if (toRob) {
            if (rob.containsKey(node)) {
                return rob.get(node);
            }
            int val = helper(node.left, false) + helper(node.right, false) + node.val;
            rob.put(node, val);
            return val;
        } else {
            if (dontRob.containsKey(node)) {
                return dontRob.get(node);
            }
            
            int val = Math.max(helper(node.left, true), helper(node.left,false)) + Math.max(helper(node.right, true), helper(node.right, false));         
            dontRob.put(node, val);
            return val;
        }
    }
}