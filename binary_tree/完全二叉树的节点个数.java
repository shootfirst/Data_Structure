class Solution {
    public int countNodes(TreeNode root) {
        // 适合所有二叉树的递归法
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
        // 迭代法层序遍历即可

        // 使用完全二叉树的性质

    }
}