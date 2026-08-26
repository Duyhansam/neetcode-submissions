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
    public int goodNodes(TreeNode root) {
            int maxSoFar = Integer.MIN_VALUE;
            return dfs(root, maxSoFar);
        }
        private int dfs (TreeNode root, int maxSoFar) {
            if (root == null) return 0;
            TreeNode node = root;
            int countGood = 0;
                if (node.val >= maxSoFar){
                    countGood++;
                }
                int newMax = Math.max(maxSoFar, node.val);
                int resLeft = dfs(node.left, newMax);
                int resRight = dfs(node.right, newMax);
                countGood += resLeft + resRight;
            return countGood;
        }
}
