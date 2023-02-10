class Solution {
    // public List<List<Integer>> levelOrder(TreeNode root) {
    // List<List<Integer>> ans = new ArrayList();
    // Queue<TreeNode> queue = new LinkedList();
    // TreeNode cur;
    // if (root == null) return ans;
    // queue.offer(root);
    // while(!queue.isEmpty()) {
    //     int size = queue.size();
    //     List<Integer> res = new ArrayList();
    //     for (int i = 0; i < size; i++) {
    //         cur = queue.poll();
    //         res.add(cur.val);
    //         if (cur.left != null) queue.offer(cur.left);
    //         if (cur.right != null) queue.offer(cur.right);
    //     }
    //     ans.add(res);
    // }
    // return ans;
    // }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        traversal(root, ans, 0);
        return ans;
    }

    public void traversal(TreeNode cur, List<List<Integer>> ans, int depth) {

        if (cur == null) return;
        if (ans.size() == depth) ans.add(new ArrayList());
        ans.get(depth).add(cur.val);
        traversal(cur.left, ans, depth + 1);
        traversal(cur.right, ans, depth + 1);

    }


}