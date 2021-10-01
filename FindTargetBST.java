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
    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        if (root == null) return k == 0;
        queue.addFirst(root);
        map.merge(root.val, 1, Integer:: sum);
        
        while(queue.size() != 0) {
            TreeNode node = queue.removeLast();
            if (node.left != null) {
                queue.add(node.left);
                map.merge(node.left.val, 1, Integer:: sum);
            }
            if (node.right != null) {
                queue.add(node.right);
                map.merge(node.right.val, 1, Integer:: sum);
            }
        }
        
        for (Integer value : map.keySet()) {
            map.merge(value, -1, Integer::sum);
            if (map.containsKey(k - value) && map.get(k - value) > 0) return true;
        }
        
        return false;
    }
}
