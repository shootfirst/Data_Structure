class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right != null) return 1 + minDepth(root.right);
        if (root.left != null && root.right == null) return 1 + minDepth(root.left);

        int leftdepth = minDepth(root.left);
        int rightdepth = minDepth(root.right);

        return Math.min(leftdepth, rightdepth) + 1;
    }

    // 迭代法层序遍历即可
}