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
              boolean diff = true;
          private int depth(TreeNode root) {
              if (root == null) return 0;
              int left = depth(root.left);
              int right = depth(root.right);
              if (Math.abs(left - right) > 1)  {
                  diff = false;
              };
             return  1 + Math.max(left, right);

          }
        public boolean isBalanced(TreeNode root) {
        depth(root);
        if (diff) return true;
        else return false;
        }
}
