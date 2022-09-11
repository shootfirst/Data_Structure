class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        TreeNode cur;
        List<Double> ret = new ArrayList();
        if (root == null) return ret;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            double res = 0;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                res += (double)cur.val;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res /= (double)size;
            ans.add(res);
        }


        return ans;
    }
}