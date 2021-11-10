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
    public void flatten(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        preOrderTraversel(root, stack);
        TreeNode cur = stack.removeLast();
        while(stack.size() != 0) {
            cur.right = stack.removeLast();
            cur = cur.right;
        }
    }
    
    void preOrderTraversel(TreeNode root, Deque<TreeNode> stack) {
        if (root == null) return;
        //do something
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        stack.addFirst(root);
        preOrderTraversel(left, stack);
        preOrderTraversel(right, stack);
        
    }
    
}
