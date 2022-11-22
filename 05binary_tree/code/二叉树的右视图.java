class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        List<Integer> ret = new ArrayList();
        TreeNode cur;
        if (root == null) return ret;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> res = new ArrayList();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                res.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            ans.add(res);
        }

        for (int i = 0; i < ans.size(); i++) {
            ret.add(ans.get(i).get(ans.get(i).size() - 1));
        }
        return ret;
    }
}