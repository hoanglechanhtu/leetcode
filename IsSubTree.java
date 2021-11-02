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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return checkSubTree(root, subRoot, false);
    }
    
    boolean checkSubTree(TreeNode root, TreeNode subRoot, boolean link) {
        boolean res = false;
        if (root == null && subRoot == null) return true;
        if (root == null) return false;
        if (subRoot == null) return false;
        
        if (root.val == subRoot.val) {
            res = checkSubTree(root.left, subRoot.left, true) && checkSubTree(root.right, subRoot.right, true);
        } 
        
        if (root.val != subRoot.val && link) return false;
        
        if (!link) {
            res = res || checkSubTree(root.left, subRoot, false) || checkSubTree(root.right, subRoot, false);
        }
        
        return res;
    }
}
