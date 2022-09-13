class Solution {
    // public boolean isValidBST(TreeNode root) {
    //     List<Integer> arr = new ArrayList();

    //     traversal(root, arr);

    //     for (int i = 0; i < arr.size() - 1; i++) {
    //         if (arr.get(i) >= arr.get(i + 1)) return false;
    //     }
    //     return true;
    // }

    // public void traversal(TreeNode root, List<Integer> arr) {
    //     if (root == null) return;
    //     traversal(root.left, arr);
    //     arr.add(root.val);
    //     traversal(root.right, arr);
    // }
    public TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (pre != null && pre.val >= root.val) return false;
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }

}