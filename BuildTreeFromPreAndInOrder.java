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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    TreeNode buildTree(int[] preorder, int[] inorder, int leftPre, int rightPre, int leftIn, int rightIn) {
        if (leftPre > rightPre) return null;
        TreeNode root = new TreeNode(preorder[leftPre]);
        if (leftPre == rightPre) return root;
        Set<Integer> set = new HashSet<>();
        //Inorder left side ..... root == inIndex ..... right side
        int inIndex = leftIn;
        while(inorder[inIndex] != preorder[leftPre]) {
            set.add(inorder[inIndex]);
            inIndex ++;
        }
        //Preorder root (left side preIndex) rightside
        int preIndex = leftPre + 1;
        while(set.size() != 0) {
            set.remove(Integer.valueOf(preorder[preIndex]));
            preIndex ++;
        }
        
        TreeNode leftNode = buildTree(preorder, inorder, leftPre + 1, preIndex - 1, leftIn, inIndex);
        TreeNode rightNode = buildTree(preorder, inorder, preIndex, rightPre, inIndex + 1, rightIn);
        root.left = leftNode;
        root.right = rightNode;
        
        return root;
    }
}
