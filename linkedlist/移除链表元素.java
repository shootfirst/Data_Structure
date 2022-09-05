class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode idx = head, pre = new ListNode(), ans;
        // 使用伪头节点
        pre.next = head;
        ans = pre;

        while (idx != null) {
            if (idx.val == val) {
                pre.next = pre.next.next;
                idx = idx.next;
            } else {
                idx = idx.next;
                pre = pre.next;
            }
        }
        return ans.next;
    }
}