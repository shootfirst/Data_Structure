class MyLinkedList {
    private class Node {
        int val;
        Node pre;
        Node next;

        Node (int val) { this.val = val; }
    }

    private int len;
    private Node head, tail;

    public MyLinkedList() {
        this.len = 0;
        this.head = new Node(0);
        this.tail = new Node(0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int index) {
        if (index >= len || index < 0) return -1;
        return getNode(index + 1).val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(len, val);
    }


    public void addAtIndex(int index, int val) {
        if (index > len ) return;

        if (index < 0) index = 0;

        Node n = new Node(val);
        Node insert = getNode(index);

        insert.next.pre = n;
        n.next = insert.next;
        n.pre = insert;
        insert.next = n;

        len++;
    }

    public void deleteAtIndex(int index) {
        if (index >= len || index < 0) {
            return;
        }
        Node delete = getNode(index);

        delete.next = delete.next.next;
        delete.next.pre = delete;
        len--;
    }

    private Node getNode(int index) {
        if (index < len / 2) {
            Node n = head;
            while(index > 0) {
                index--;
                n = n.next;
            }
            return n;
        } else {
            Node n = tail;
            index = len - index + 1;
            while(index > 0) {
                index--;
                n = n.pre;
            }
            return n;
        }

    }

}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */