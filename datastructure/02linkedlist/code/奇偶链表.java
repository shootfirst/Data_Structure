class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode od = head;
        ListNode ev = head.next;

        ListNode slow = od;
        ListNode fast = ev;

        while (fast != null && fast.next != null) {
            slow.next = fast.next;
            slow = slow.next;
            fast.next = fast.next.next;
            fast = fast.next;
        }

        slow.next = ev;

        return od;

    }
}