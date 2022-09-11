class Solution {
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList();
    //     traversal(root, ans);
    //     return ans;
    // }

    // public void traversal(TreeNode root, List ans) {
    //     if (root == null) return;

    //     traversal(root.left, ans);
    //     traversal(root.right, ans);
    //     ans.add(root.val);

    // }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        Deque<TreeNode> stack = new LinkedList();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (cur.right == null || cur.right == pre) {
                    ans.add(cur.val);
                    pre = cur;
                    cur = null;

                } else {
                    stack.push(cur);
                    cur = cur.right;
                }
            }
        }
        return ans;
    }
}