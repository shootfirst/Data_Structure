class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList();
        Node cur;
        Node pre = null;
        if (root == null) return root;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> res = new ArrayList();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (pre != null) pre.next = cur;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                pre = cur;
            }
            pre = null;
        }
        return root;
    }
}