class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode[]> queue = new LinkedList();
        if (root == null) return false;
        queue.offer(new TreeNode[] {null, root});

        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode[] cs1 = null;
            TreeNode[] cs2 = null;
            for (int i = 0; i < size; i++) {
                TreeNode[] cur = queue.poll();
                if (cur[1].val == x) cs1 = cur;
                if (cur[1].val == y) cs2 = cur;
                if (cs1 != null && cs2 != null) {
                    if (cs1[0] != cs2[0]) return true;
                    else return false;
                }
                if (cur[1].left != null) queue.offer(new TreeNode[] {cur[1], cur[1].left});
                if (cur[1].right != null) queue.offer(new TreeNode[] {cur[1], cur[1].right});
            }
            cs1 = null;
            cs2 = null;
        }

        return false;
    }
}