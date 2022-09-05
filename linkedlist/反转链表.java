class Solution {
    public ListNode reverseList(ListNode head) {
        // 迭代法
        // ListNode idx = head, ans = null;

        // while(head != null) {
        //     idx = head.next;
        //     head.next = ans;
        //     ans = head;
        //     head = idx;
        // }

        // return ans;

        // 递归法,以前写过，现在忘了，看别人提示才想起来，重拾leetcode的第二天
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reverse = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return reverse;


    }
}