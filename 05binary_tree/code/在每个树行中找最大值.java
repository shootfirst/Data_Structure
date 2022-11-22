class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        TreeNode cur;
        if (root == null) return ans;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                res = Math.max(res, cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            ans.add(res);
        }
        return ans;
    }
}