class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        ListNode newhead = reverseList(head);

        if (fast == null) {
            newhead = newhead.next;
        }

        while (head2 != null) {
            if (head2.val != newhead.val) {
                return false;
            }
            head2 = head2.next;
            newhead = newhead.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        // 迭代法
        ListNode idx = head, ans = null;

        while(head != null) {
            idx = head.next;
            head.next = ans;
            ans = head;
            head = idx;
        }

        return ans;

    }

}