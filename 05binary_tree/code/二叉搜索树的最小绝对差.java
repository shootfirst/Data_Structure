class Solution {
    public TreeNode pre = null;
    public long res = Long.MAX_VALUE;
    public void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        if (pre != null) res = Math.min(Math.abs(root.val - pre.val), res);
        pre = root;
        traversal(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return (int)res;
    }
}