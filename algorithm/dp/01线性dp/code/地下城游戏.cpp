class Solution {
public:
// https://leetcode.cn/problems/dungeon-game/
    int max_num = 10000000;
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
        int m = dungeon.size(), n = dungeon[0].size();
        vector<vector<int>> dp (m + 1, vector<int>(n + 1, 0));

        for (int i = 0; i <= m; i++) dp[i][n] = max_num;
        for (int j = 0; j <= n; j++) dp[m][j] = max_num;

        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1; // notice
        dp[m][n] = 0;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = max(min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1);
            }
        }

        return dp[0][0];
    }
};