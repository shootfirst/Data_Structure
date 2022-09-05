class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        Node n = head;
        while(n != null) {
            while (n != null && n.child == null) {
                n = n.next;
            }

            if (n != null) {
                // 递归炮决之
                Node child = flatten(n.child);
                n.child = null;

                Node next = n.next;
                n.next = child;
                child.prev = n;

                while (child.next != null) child = child.next;

                child.next = next;
                if (next != null) next.prev = child;


                n = next;
            }
        }
        return head;
    }
}