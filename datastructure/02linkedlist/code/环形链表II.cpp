class Solution {
public:
// https://leetcode.cn/problems/linked-list-cycle-ii/
    ListNode *detectCycle(ListNode *head) {
        ListNode *fast = head, *slow = head;

        while (fast != nullptr && fast->next != nullptr) {
            fast = fast->next->next;
            slow = slow->next;
            // 有环
            if (fast == slow) {
                slow = head;

                while (fast != slow) {
                    fast = fast->next;
                    slow = slow->next;
                }
                return slow;
            }
        }

        return nullptr;
        
    }
};