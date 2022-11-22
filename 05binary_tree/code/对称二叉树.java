class Solution {
    // public boolean isSymmetric(TreeNode root) {
    //     if (root == null) return true;
    //     return compare(root.left, root.right);
    // }

    // public boolean compare(TreeNode left, TreeNode right) {
    //     if (left == null && right != null) return false;
    //     if (left != null && right == null) return false;
    //     if (left == null && right == null) return true;
    //     if (left.val != right.val) return false;

    //     return compare(left.left, right.right) && compare(left.right, right.left);
    // }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList();

        q.offer(root.left);
        q.offer(root.right);

        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();

            if (left == null && right == null) continue;

            if (left != null && right == null
                    || left == null && right != null || left.val != right.val) return false;

            q.offer(left.left);
            q.offer(right.right);
            q.offer(left.right);
            q.offer(right.left);

        }

        return true;
    }
}