class Solution {
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList();
    //     traversal(root, ans);
    //     return ans;
    // }

    // public void traversal(TreeNode root, List ans) {
    //     if (root == null) return;

    //     traversal(root.left, ans);
    //     ans.add(root.val);
    //     traversal(root.right, ans);

    // }

    public List<Integer> inorderTraversal(TreeNode root) {
        // https://leetcode.cn/problems/binary-tree-inorder-traversal/
        List<Integer> ans = new ArrayList();
        Deque<TreeNode> stack = new LinkedList();

        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                ans.add(cur.val);
                cur = cur.right;
            }
        }

        return ans;
    }
}