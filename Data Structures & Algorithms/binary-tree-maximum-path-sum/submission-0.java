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
       int maxSum=Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
        }
        private int dfs(TreeNode node) {
            if (node == null) return 0;
            int leftGain = dfs(node.left);
            int rightGain = dfs(node.right);
            if (leftGain < 0) leftGain = 0;
            if (rightGain < 0) rightGain = 0;
            int sumB = node.val +leftGain+rightGain;
            maxSum = Math.max(sumB, maxSum);

            int sumA = node.val + Math.max(leftGain,rightGain);
            return sumA;
        }
}
