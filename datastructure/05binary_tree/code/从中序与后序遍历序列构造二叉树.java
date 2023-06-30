class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
        if (postorder.length == 0) return null;

        int root = postorder[postorder.length - 1];
        TreeNode r = new TreeNode(root);
        int in = 0;

        if (postorder.length == 1) return r;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                in = i;
                break;
            }
        }

        int[] inleft = Arrays.copyOfRange(inorder, 0, in);
        int[] inright = Arrays.copyOfRange(inorder, in + 1, inorder.length);
        int[] postleft = Arrays.copyOfRange(postorder, 0, in);
        int[] postright = Arrays.copyOfRange(postorder, in, inorder.length - 1);


        r.left = buildTree(inleft, postleft);
        r.right = buildTree(inright, postright);
        return r;
    }
}