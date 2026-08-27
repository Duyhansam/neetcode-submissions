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

public class Codec {

    // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
           serializeHelper(root, sb);
        return sb.toString();
        }
        private void serializeHelper(TreeNode node , StringBuilder sb) {
            if (node == null) sb.append("#,");
            else {
                sb.append(node.val + ",");
                serializeHelper(node.left, sb);
                serializeHelper(node.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
        String [] res =  data.split(",");
            Queue<String> queue = new LinkedList<>();
            for(int i=0;i<res.length;i++){
                queue.offer(res[i]);
            }
            return deserializeHelper(queue);
        }
        private TreeNode deserializeHelper( Queue<String> queue) {
            String a = queue.poll();
            if(a.equals("#")){
                return null;
            }else {
                TreeNode node = new TreeNode(Integer.parseInt(a));
                node.left = deserializeHelper(queue);
                node.right = deserializeHelper(queue);
            return node;
            }
        }
}
