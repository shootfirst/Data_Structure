class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return traversel(root, targetSum, 0);
    }

    public boolean traversel(TreeNode root, int targetSum, int sum) {
        // 叶子节点
        if (root.left == null && root.right == null) {
            if (sum + root.val == targetSum) return true;
        }
        boolean leftb = false, rightb = false;

        if (root.left != null) {
            leftb = traversel(root.left, targetSum, sum + root.val);
        }
        if (root.right != null) {
            rightb = traversel(root.right, targetSum, sum + root.val);
        }
        return leftb || rightb;
    }

    //迭代法，同二叉树所有路径
}