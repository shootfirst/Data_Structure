class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        int root = preorder[0];
        TreeNode r = new TreeNode(root);
        int in = 0;

        if (preorder.length == 1) return r;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                in = i;
                break;
            }
        }

        int[] inleft = Arrays.copyOfRange(inorder, 0, in);
        int[] inright = Arrays.copyOfRange(inorder, in + 1, inorder.length);
        int[] preleft = Arrays.copyOfRange(preorder, 1, in + 1);
        int[] preright = Arrays.copyOfRange(preorder, in + 1, inorder.length);


        r.left = buildTree(preleft, inleft);
        r.right = buildTree(preright, inright);
        return r;
    }
}