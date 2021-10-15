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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        queue.addFirst(root);
        while(queue.size() != 0) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size != 0) {
                TreeNode node = queue.removeLast();
                list.add(node.val);
                if (node.left != null) queue.addFirst(node.left);
                if (node.right != null) queue.addFirst(node.right);
                
                size--;
            }
            res.add(list);
        }
        
        return res;
    }
}
