class Solution {
public:
// https://leetcode.cn/problems/minimum-window-substring/
    string minWindow(string s, string t) {
        int m = s.size(), n = t.size();
        int left = 0, right = 0;
        unordered_map<char, int> t_cnt(0);
        for (int i = 0; i < n; i++) {
            t_cnt[t[i]]++;
        }
        int total_match = t_cnt.size();
        unordered_map<char, int> s_cnt(0);
        int match = 0;
        int ans_left = -1, ans_right = 0;

        while (right < m) {
            s_cnt[s[right]]++;

            // 找到右边界
            if (s_cnt[s[right]] == t_cnt[s[right]]) {
                match++;
                if (match == total_match) {
                    while (left <= right) {
                        s_cnt[s[left]]--;
                         // 找到左边界 
                        if (s_cnt[s[left]] < t_cnt[s[left]]) {
                            match--;
                            // 比较是否最小
                            if (ans_left == -1 || ans_right - ans_left > right - left) {
                                ans_left = left;
                                ans_right = right;
                            }
                            left++;
                            break;

                        } else {
                            left++;
                        }
                    }

                }
            }

            right++;
        }

        return ans_left == -1 ? "" : s.substr(ans_left, ans_right - ans_left + 1);
    }
};