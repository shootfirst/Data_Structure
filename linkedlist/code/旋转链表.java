class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode l = head;
        int len = 0;

        while (l != null) {
            l = l.next;
            len++;
        }

        if (k >= len) k %= len;

        if (k == 0) return head;

        ListNode slow = head, fast = head.next;

        for (; k > 1; k--) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode rev = slow.next;
        slow.next = null;

        ListNode ans = rev;
        while (rev.next != null) rev = rev.next;
        rev.next = head;

        return ans;



    }
}