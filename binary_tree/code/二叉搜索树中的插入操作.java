class Solution {
    TreeNode pre = null;
    TreeNode r;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        r = root;
        traversal(root, val);
        return r;
    }
    public void traversal(TreeNode root, int val) {
        if (root == null) {
            if (pre == null) r = new TreeNode(val);
            else if (pre.val < val) pre.right = new TreeNode(val);
            else pre.left = new TreeNode(val);
            return;
        }
        pre = root;
        if (root.val < val) traversal(root.right, val);
        if (root.val > val) traversal(root.left, val);
    }
}