class Solution {
public:
// https://leetcode.cn/problems/longest-palindromic-substring/
    string longestPalindrome(string s) {
        int n = s.size();
        bool dp[n][n];
        memset(dp, 0, sizeof(dp));
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        string ans = s.size() == 0 ? "" : s.substr(0, 1);
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int left = i, right = i + len - 1;
                if (left == right - 1) {
                    dp[left][right] = s[left] == s[right];
                } else {
                    dp[left][right] = dp[left + 1][right - 1] && s[left] == s[right];
                }
                if (dp[left][right] && len > ans.size()) {
                    ans = s.substr(left, len);
                }
            }
        }

        return ans;
    }
};