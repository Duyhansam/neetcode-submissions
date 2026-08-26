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
         Queue<TreeNode> queue = new ArrayDeque<>();
            if (root == null) {
                return new ArrayList<>();
            }
            queue.add(root);
            List<List<Integer> > res = new ArrayList<>();
            while(!queue.isEmpty()){
                int size = queue.size();
                List<Integer> levelList = new ArrayList<>();
                for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                }
                res.add(levelList);

            }
            return res;
    }
}
