public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenga = 0, lengb = 0;

        ListNode a = headA, b = headB;
        while(a != null) {
            a = a.next;
            lenga++;
        }
        while(b != null) {
            b = b.next;
            lengb++;
        }

        a = headA;
        b = headB;

        if (lenga > lengb) {
            for (int i = 0; i < lenga - lengb; i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < lengb - lenga; i++) {
                b = b.next;
            }
        }

        while (a != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }
}