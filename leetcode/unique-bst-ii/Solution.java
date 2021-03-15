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
    Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.


    */
    public List<TreeNode> generateTrees(int n) {
        
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        
        return generateTree(1, n);
    }
    
    public List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        
        
        if (start == end) {
            ans.add(new TreeNode(start));
            return ans;
        }
        
        for (int i = start; i <= end; i ++) {
            List<TreeNode> left = generateTree(start, i - 1);
            List<TreeNode> right = generateTree(i + 1, end);
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    ans.add(node);
                }
            }
        } 
        
        return ans;
        
    }
}