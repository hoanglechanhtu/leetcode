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
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    boolean checkBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min) return false;
        if (root.val >= max) return false;
        boolean res = true;
        res = res && checkBST(root.left, min, Math.min(max, root.val));
        res = res && checkBST(root.right, Math.max(min, root.val), max);
        
        return res;
    }
}
