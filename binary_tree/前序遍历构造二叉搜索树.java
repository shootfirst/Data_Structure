class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return traversal(preorder, 0, preorder.length - 1);
    }

    public TreeNode traversal(int[] preorder, int start, int end) {

        if (start > end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        if (start == end) return root;

        int left = start + 1, right = end + 1;

        for (int i = start + 1; i <= end; i++) {
            if (preorder[i] > preorder[start]) {
                right = i;
                break;
            }
        }

        root.left = traversal(preorder, left, right - 1);
        root.right = traversal(preorder, right, end);
        return root;
    }
}