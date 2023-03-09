class Solution {
public:
    int minDistance(string word1, string word2) {
        int m = word1.size(), n = word2.size();
        vector<vector<int>> dp (m + 1, vector<int>(n + 1));

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int left = dp[i - 1][j] + 1;      // 增
                int down = dp[i][j - 1] + 1;      // 删
                int left_down = dp[i - 1][j - 1]; // 改
                if (word1[i - 1] != word2[j - 1]) { 。// 相同则不用改
                    left_down += 1;
                }
                dp[i][j] = min(left, min(down, left_down));
            }
        }
        return dp[m][n];
    }
};