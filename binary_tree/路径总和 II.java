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

    private List<List<Integer>> ans = new ArrayList();
    private List<Integer> stack = new LinkedList();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) return ans;
        stack.add(root.val);
        traversel(root, targetSum, root.val);
        return ans;
    }

    public void traversel(TreeNode root, int targetSum, int sum) {
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                ans.add(new LinkedList<>(stack));
            }
        }

        if (root.left != null) {
            stack.add(root.left.val);
            traversel(root.left, targetSum, sum + root.left.val);
            stack.remove(stack.size() - 1); // 回溯
        }

        if (root.right != null) {
            stack.add(root.right.val);
            traversel(root.right, targetSum, sum + root.right.val);
            stack.remove(stack.size() - 1); //回溯
        }
    }
}