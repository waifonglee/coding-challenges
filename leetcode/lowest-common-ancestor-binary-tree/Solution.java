/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    /*
    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two
    nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to
    be a descendant of itself).”
    
    4 cases:
    1. 2 nodes have the same parent and are on the same level: LCA = parent
    2. 2 nodes on the same level but different parent: LCA = LCA of 2 parent nodes
    3. 2 nodes on different level but one node is parent / grandparent of another: LCA = taller node
    4. 2 nodes on different level and not related: LCA = LCA of the 2 parent nodes

    */
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        HashMap<TreeNode, Integer> level = new HashMap<>();
        boolean foundP = false;
        boolean foundQ = false;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        level.put(root, 0);
        
        while (!foundP || !foundQ) {
            TreeNode curr = qu.poll();
            if (curr == p) {
                foundP = true;
            }
            
            if (curr == q) {
                foundQ = true;
            }
            
            //System.out.println(curr.val);
            //System.out.println(foundP);
            //System.out.println(foundQ);
            if (curr.left != null) {
                map.put(curr.left, curr);
                qu.offer(curr.left);
                level.put(curr.left, level.get(curr) + 1);
                //System.out.println(curr.left.val);
            }
            
            if (curr.right != null) {
                map.put(curr.right, curr);
                qu.offer(curr.right);
                level.put(curr.right, level.get(curr) + 1);
                //System.out.println(curr.right.val);
            }
        }
        //System.out.println("here");
        return lca(p, q, map, level);
        
    }
    
    public TreeNode lca(TreeNode p, TreeNode q, HashMap<TreeNode, TreeNode> map,
                        HashMap<TreeNode, Integer> lvl) {
        //System.out.println(p.val + " " + q.val);
        int levelP = lvl.get(p);
        int levelQ = lvl.get(q);
        if (levelP == 0) {
            return p;
        }
        if (levelQ == 0) {
            return q;
        }
        //System.out.println(levelP + " lvl " + levelQ);
        TreeNode currP = p;
        TreeNode currQ = q;
        
        while(levelP != levelQ) {
            if (levelP > levelQ) {
                currP = map.get(currP);
                levelP = lvl.get(currP);
            } else {
                currQ = map.get(currQ);
                levelQ = lvl.get(currQ);
            }
        }
        
        if (currP == currQ) {
            return currP;
        }
        
        return lca(map.get(p), map.get(q), map, lvl);
    }
    
    
    //faster sol where we search for p and q in left & right subtree. 
    // if both are in right subtree, it is the lca. if one in left, one in right, the root is the lca
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root || root == null) {
            return root;
        }
        
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        
        if (l != null && r != null) {
            return root;
        } else if (l != null && r == null) {
            return l;
        } else {
            return r;
        }        
    }
}