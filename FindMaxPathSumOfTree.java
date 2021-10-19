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
    int max = 0;
    public int maxPathSum(TreeNode root) {
        max = root.val;        
        findMaxSum(root);
        
        return max;
    }
    
    int findMaxSum(TreeNode root) {
        if (root == null) return 0;
        
        int leftValue = findMaxSum(root.left);
        int rightValue = findMaxSum(root.right);
        max = Math.max(max, root.val);
        max = Math.max(max, leftValue + root.val);
        max = Math.max(max, rightValue + root.val);
        max = Math.max(max, leftValue + rightValue + root.val);
        return Math.max(leftValue + root.val, Math.max(rightValue + root.val, root.val));
        
    }
}
