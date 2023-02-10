class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode last = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (last.val < cur.val) {
                last = last.next;
            } else {
                ListNode pre = dummy;
                while (pre.next.val < cur.val) {
                    pre = pre.next;
                }
                last.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = last.next;
        }

        return dummy.next;

    }
}