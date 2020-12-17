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
 Given a binary tree, return the level order traversal of its nodes'
 values. (ie, from left to right, level by level).
 For example:
 Given binary tree [3,9,20,null,null,15,7],
 [[3],
  [9,20],
  [15,7]]
  Use a queue can be faster??? but idk how to track the level tho. 
 */

class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    int current = -1;
    public List<List<Integer>> levelOrder(TreeNode root) {
        travel(0, root);
        return ans;
        
    }
    
    public void travel(int level, TreeNode root) {
        if (root == null) {
            return;
        }
        if (level > current) {
            List<Integer> lst = new ArrayList<Integer>();
            lst.add(root.val);
            ans.add(lst);
            current = level;
        } else {
            List<Integer> lst = ans.get(level);
            lst.add(root.val);
            ans.set(level, lst);
        }
        travel(level + 1, root.left);
        travel(level + 1, root.right);
    }
}