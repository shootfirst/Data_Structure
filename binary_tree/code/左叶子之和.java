class Solution {
    // 递归法
    // public int sumOfLeftLeaves(TreeNode root) {
    //     if (root == null) return 0;

    //     int leftval = sumOfLeftLeaves(root.left);
    //     //左叶子节点
    //     if (root.left != null && root.left.left == null && root.left.right == null) {
    //         leftval = root.left.val;
    //     }
    //     int rightval = sumOfLeftLeaves(root.right);

    //     return leftval + rightval;

    // }

    // 迭代法，遍历所有节点判断其是否是左叶子节点即可
    public int sumOfLeftLeaves(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> stack = new LinkedList();
        if (root == null) return ans;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            //左叶子节点
            if (root.left != null && root.left.left == null && root.left.right == null) {
                ans += root.left.val;
            }
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }
        return ans;
    }











}