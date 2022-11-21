class MyLinkedList {
    private class Node {
        int val;
        Node next;
        Node (int val) { this.val = val; }
    }

    private int len;
    private Node head;

    public MyLinkedList() {
        this.len = 0;
        this.head = new Node(0);
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
        if (index > len) return;

        if (index < 0) index = 0;

        Node n = new Node(val);
        Node insert = getNode(index);

        Node next = insert.next;
        insert.next = n;
        n.next = next;

        len++;
    }

    public void deleteAtIndex(int index) {
        if (index >= len || index < 0) {
            return;
        }
        Node delete = getNode(index);

        delete.next = delete.next.next;
        len--;
    }

    private Node getNode(int index) {
        Node n = head;
        while(index > 0) {
            index--;
            n = n.next;
        }
        return n;
    }
}