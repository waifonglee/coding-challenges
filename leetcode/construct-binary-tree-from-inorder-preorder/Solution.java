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
 
    Given preorder and inorder traversal of a tree, construct the binary tree.

    Note:
    You may assume that duplicates do not exist in the tree.

    Depth First Traversals:
    (a) Inorder (Left, Root, Right) : 4 2 5 1 3
    (b) Preorder (Root, Left, Right) : 1 2 4 5 3
    (c) Postorder (Left, Right, Root) : 4 5 2 3 1
 */
class Solution {
    int preIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> in = new HashMap<>(); //bc theres no duplicates in the tree
        
        if (preorder.length == 0) {
            return null;
        }
        for (int i = 0; i < preorder.length; i++) {
            in.put(inorder[i], i);
        }
        preIndex = 0;
        int rootVal = preorder[preIndex];
        TreeNode root = new TreeNode(rootVal);
        root.left = build(in, preorder, 0, in.get(rootVal) - 1);
        root.right = build(in, preorder, in.get(rootVal) + 1, preorder.length - 1);
        return root;
    }
    
    public TreeNode build(HashMap<Integer, Integer> in, int[] preorder, int inStart, int inEnd) {
        //System.out.println(inStart + " " + inEnd + " preindex: " + preIndex);
        if (inStart > inEnd) {
            return null;
        }
        preIndex ++; //because we always calculate left tree first
        int rootVal = preorder[preIndex];
        TreeNode root = new TreeNode(rootVal);
        
        if (inStart == inEnd) {
            return root;
        }
        
        int ind = in.get(rootVal);
        root.left = build(in, preorder, inStart, ind - 1);
        root.right = build(in, preorder, ind + 1, inEnd);
        return root;
    }
    
}