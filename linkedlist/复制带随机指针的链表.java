class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap();

        Node idx = head.next;
        Node ans = new Node(head.val);
        map.put(head, ans);
        Node pre = ans;

        while (idx != null) {
            Node n = new Node(idx.val);
            map.put(idx, n);
            pre.next = n;
            pre = pre.next;
            idx = idx.next;
        }

        idx = head;
        pre = ans;

        while (idx != null) {
            if (idx.random != null) {
                pre.random = map.get(idx.random);
            }
            idx = idx.next;
            pre = pre.next;
        }

        return ans;
    }
}