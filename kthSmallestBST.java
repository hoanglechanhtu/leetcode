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
    Integer counter = 0;
    Integer smallest = 0;
    public int kthSmallest(TreeNode root, int k) {
        find(root, k);
        return smallest;
    }
    
    void find(TreeNode root, int k) {
        if (root == null) return;
        find(root.left, k);
        counter ++;
        if (counter == k) smallest = root.val;
        find(root.right, k);
    }
}
