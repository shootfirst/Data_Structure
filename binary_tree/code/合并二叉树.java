class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 != null && root2 == null) return root1;
        if (root1 == null && root2 != null) return root2;

        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);

        return root;
    }
    // 迭代法使用层序遍历，同时推入两个相同位置的节点，若一方为空则直接赋值过去即可
}