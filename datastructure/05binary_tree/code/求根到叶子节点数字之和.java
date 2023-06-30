class Solution {
    // https://leetcode.cn/problems/sum-root-to-leaf-numbers/
    int res = 0;
    Deque<Integer> stack = new LinkedList();
    public int sumNumbers(TreeNode root) {
        traversal(root);
        return res;

    }

    private void traversal(TreeNode root) {
        if (root == null) return;
        else if (root.left == null && root.right == null) {
            if (stack.isEmpty()) res += root.val;
            else res += stack.getFirst() * 10 + root.val;
            return;
        } else {
            if (stack.isEmpty()) stack.push(root.val);
            else stack.push(stack.getFirst() * 10 + root.val);

            if (root.left != null) traversal(root.left);
            if (root.right != null) traversal(root.right);

            stack.pop(); // 回溯
        }
    }
}