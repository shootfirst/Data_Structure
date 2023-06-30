class Solution {
    // https://leetcode.cn/problems/binary-tree-level-order-traversal/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        TreeNode cur;
        if (root == null) return ans;
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
        return ans;
    }

    
}