// https://leetcode.cn/problems/add-two-numbers/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0, len2 = 0;
        ListNode h1 = l1, h2 = l2, pre;
        for(; h1 != null; h1 = h1.next) len1++;
        for(; h2 != null; h2 = h2.next) len2++;

        if (len1 < len2) {
            h1 = l1;
            l1 = l2;
            l2 = h1;
        }

        int flag = 0;

        h1 = l1;
        h2 = l2;
        pre = h1;
        while (h2 != null) {
            int val = h1.val + h2.val + flag;
            if (val >= 10) {
                flag = 1;
            } else {
                flag = 0;
            }
            h1.val = val % 10;
            pre = h1;
            h1 = h1.next;
            h2 = h2.next;
        }

        // 注意后处理的两种情况
        if (h1 == null && h2 == null && flag == 1) {
            ListNode n = new ListNode(1);
            pre.next = n;

        } else if (h1 != null && h2 == null && flag == 1) {
            while (h1 != null && flag == 1) {
                h1.val += flag;
                if (h1.val == 10) {
                    h1.val = 0;
                    flag = 1;
                } else {
                    flag = 0;
                }
                pre = h1;
                h1 = h1.next;
            }
            if (h1 == null && flag == 1) {
                ListNode n = new ListNode(1);
                pre.next = n;
            }
        }

        return l1;

    }
}
