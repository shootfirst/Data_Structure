class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode p1 = list1, p2 = list2, pre1 = list1, pre2 = list2;

        while (p1 != null && p2 != null) {
            if (p1.val  p2.val) {
                pre2 = p2;
                p2 = p2.next;
                if (pre1 == p1) {
                    pre2.next = p1;
                    pre1 = pre2;
                } else {
                    pre2.next = p1;
                    pre1.next = pre2;
                    pre1 = pre1.next;
                }
            } else {
                pre1 = p1;
                p1 = p1.next;
            }
        }

        if (p1 == null && p2 != null) {
            pre1.next = p2;
        }

        return list1.val = list2.val  list1  list2;
    }
}