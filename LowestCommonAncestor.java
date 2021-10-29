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
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return res;
    }
    
    boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
       
        boolean left = find(root.left, p, q);
        boolean right = find(root.right, p, q);
        boolean cur = root.val == q.val || root.val == p.val;
        if (res == null){
            if ((left && right) || (left && cur) || (right && cur)) res = root;
        }
        
        return left || right || cur;
    }
}
