class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) == -1 ? false : true;
    }

    // 注意求高度和求深度的不同
    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftheight = getHeight(root.left);
        int rightheight = getHeight(root.right);

        if (leftheight == -1) return -1;
        if (rightheight == -1) return -1;

        if (Math.abs(leftheight - rightheight) > 1) return -1;
        return Math.max(leftheight, rightheight) + 1;
    }

    // 迭代法见代码随想录


}