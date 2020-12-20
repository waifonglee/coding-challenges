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
 
    Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left
    to right, then right to left for the next level and alternate between).
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int current = -1; //current % 2 == 0 -> left to right. current % 2 == 1 -> right to left
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        travel(0, root);
        for (int i = 0; i < ans.size(); i ++ ) {
            if (i % 2 != 0) {
                List<Integer> lst = ans.get(i);
                Collections.reverse(lst);
                ans.set(i, lst);
            }
        }
        
        return ans;
    }
    
    public void travel(int level, TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (level > current) {
            List<Integer> lst = new ArrayList<>();
            lst.add(root.val);
            ans.add(lst);
            current = level;
        } else {
            ans.get(level).add(root.val);
        }
        
        travel(level + 1, root.left);
        travel(level + 1, root.right);
        
    }
}