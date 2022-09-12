class Solution {
    int res;
    int max_depth = -1;
    public int findBottomLeftValue(TreeNode root) {
        //迭代法层序遍历可秒杀之，此处只介绍递归法
        // 判断是否是最大深度获取叶子节点，而通过前序遍历获取最左边叶子节点
        traversal(root, 0);
        return res;
    }

    public void traversal(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            //这里只能大于，不能大于等于，这是确定左优先的关键
            if (depth > max_depth) {
                max_depth = depth;
                res = root.val;
            }
            return;
        }

        if (root.left != null) traversal(root.left, depth + 1);

        if (root.right != null) traversal(root.right, depth + 1);

    }
}