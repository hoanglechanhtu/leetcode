/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return dfs(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data == "") return null;
        String[] list = data.split("-");
        int[] arr = new int[list.length];
        for (int i = 0; i < list.length; i ++) {
            arr[i] = Integer.valueOf(list[i]);
        }
        return deserialize(arr, 0, arr.length - 1);
    }
    
    String dfs(TreeNode root) {
        if (root == null) return null;
        String s = "" + root.val;
        String left = dfs(root.left);
        if (left != null) s = s + "-" + left;
        String right = dfs(root.right);
        if (right != null) s = s + "-" + right;
        return s;
    }
    //2-1-3
    TreeNode deserialize(int[] data, int from, int to) {
        if (from > to) return null;
        TreeNode node = new TreeNode(data[from]);
        int start = from;
        int middle = start + 1;
        while (middle <= to && data[middle] < data[start]) {
            middle ++;
        }
        
        if (middle == to + 1) {
            node.left = deserialize(data, from + 1, to);
        } else {
            node.left = deserialize(data, from + 1, middle - 1);
            node.right = deserialize(data, middle, to);
            
        }
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
