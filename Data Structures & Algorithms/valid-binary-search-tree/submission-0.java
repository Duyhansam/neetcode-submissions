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
   public boolean isValidBST(TreeNode root) {
            long lower = Integer.MIN_VALUE;
            long upper = Integer.MAX_VALUE;
            return dfs(root, lower, upper);

        }

        private boolean dfs(TreeNode root, long lower, long upper) {
            TreeNode node = root;
            if (node == null) return true;
            if (!(node.val > lower && node.val < upper)) return false;

            boolean leftok = dfs(node.left, lower, node.val);
            boolean rightok = dfs(node.right, node.val, upper);

            return leftok && rightok;
        }
}
