class Solution {
public:
// https://leetcode.cn/problems/wildcard-matching/
    bool isMatch(string s, string p) {
        int m = s.size(), n = p.size();

        vector<vector<bool>> dp (m + 1, vector<bool>(n + 1));

        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j <= n; j++) {
            if (p[j - 1] == '*') {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = false;
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p[j - 1] == '*') {
                    // dp[i - 1][j]表示不使用*匹配，dp[i][j - 1]表示使用*匹配一个，这里会递归匹配
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && s[i - 1] == p[j - 1];
                }
            }
        }
        return dp[m][n];
        
    }
};