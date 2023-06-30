class Solution {
public:
// https://leetcode.cn/problems/reorder-list/
    // 寻找链表中点：快慢指针
    ListNode* find_mid(ListNode* head) {
        auto fast = head, slow = head;
        while (fast != nullptr && fast->next != nullptr) {
            fast = fast->next->next;
            if (fast == nullptr) {
                auto res = slow->next;
                slow->next = nullptr;
                return res;
            }
            slow = slow->next;
        }
        auto res = slow->next;
        slow->next = nullptr;
        return res;
    }

    // 反转链表
    ListNode* reverse(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        auto res = reverse(head->next);
        head->next->next = head;
        head->next = nullptr;
        return res;
    }

    // 合并两条链表
    void merge(ListNode* first, ListNode* second) {
        auto p = first, q = second;
        while (p != nullptr && q != nullptr) {
            auto res1 = p->next;
            auto res2 = q->next;
            p->next = q;
            q->next = res1;
            p = res1;
            q = res2;
        }
    }

    void reorderList(ListNode* head) {
        // 1.寻找链表中点
        auto first = head, second = find_mid(head);
        // 2.将链表后部分反转
        second = reverse(second);
        // 3.合并两条链表
        merge(first, second);
    }
};


