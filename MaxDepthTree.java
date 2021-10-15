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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + getMaxDepth(root);
    }
    int getMaxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        if (root.left != null) depth = Math.max(depth, getMaxDepth(root.left) + 1);
        if (root.right != null) depth = Math.max(depth, getMaxDepth(root.right) + 1);
        return depth;
    }
}
