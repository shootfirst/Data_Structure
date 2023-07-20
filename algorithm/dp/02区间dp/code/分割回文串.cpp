class Solution {
public:
// https://leetcode.cn/problems/palindrome-partitioning-ii/
    int minCut(string s) {
        int n = s.size();

        // ----------------------------
        bool dp[n][n];
        memset(dp, 0, sizeof(dp));
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int left = i, right = i + len - 1;
                if (len == 2) {
                    dp[left][right] = s[left] == s[right];
                } else {
                    dp[left][right] = dp[left + 1][right - 1] && s[left] == s[right];
                }
            }
        }

        // ----------------------------
        int f[n];
        f[0] = 0;
        for (int i = 1; i < n; i++) {
            f[i] = INT_MAX;
        }
        
        for (int i = 1; i < n; i++) {
            if (dp[0][i]) {
                f[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j + 1][i]) {
                    f[i] = min(f[i], f[j] + 1);
                }
            }
        }

        return f[n - 1];
    }
};