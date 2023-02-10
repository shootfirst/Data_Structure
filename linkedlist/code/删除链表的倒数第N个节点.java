class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head, pre = head;

        for (int i = 0; i < n - 1; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if (pre == slow) {
            head = head.next;
        } else {
            pre.next=pre.next.next;
        }
        return head;
    }
}