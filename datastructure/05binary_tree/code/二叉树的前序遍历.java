class Solution {
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList();
    //     traversal(root, ans);
    //     return ans;
    // }

    // public void traversal(TreeNode root, List ans) {
    //     if (root == null) return;
    //     ans.add(root.val);
    //     traversal(root.left, ans);
    //     traversal(root.right, ans);

    // }

    public List<Integer> preorderTraversal(TreeNode root) {
        // https://leetcode.cn/problems/binary-tree-preorder-traversal/
        Deque <TreeNode> stack = new LinkedList();
        List<Integer> ans = new ArrayList();
        if (root == null) return ans;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();

            if (n.right != null) stack.push(n.right);
            if (n.left != null) stack.push(n.left);
            ans.add(n.val);
        }

        return ans;
    }
}