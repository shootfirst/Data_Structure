class Solution {
    public TreeNode invertTree(TreeNode root) {
        // 前序遍历
        // if (root == null) return null;
        // TreeNode temp = root.left;
        // root.left = root.right;
        // root.right = temp;
        // invertTree(root.left);
        // invertTree(root.right);
        // return root;

        // 后序遍历
        // if (root == null) return null;
        // invertTree(root.left);
        // invertTree(root.right);
        // TreeNode temp = root.left;
        // root.left = root.right;
        // root.right = temp;
        // return root;

        // 层序遍历
        TreeNode ans = root;
        Queue<TreeNode> q = new LinkedList();
        if (root == null) return null;
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                root = q.poll();
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                if (root.left != null) q.offer(root.left);
                if (root.right != null) q.offer(root.right);
            }
        }
        return ans;



    }
}