class Solution {
public:
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
        int m = dungeon.size();
        int n = dungeon[0].size();
        // 注意，这个递归方向是右下到左上，传统的左上到右下不满足后效性
        vector<vector<int>> dp (m + 1, vector<int>(n + 1, INT_MAX));
        // 用于第一次的递归
        dp[m][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // dp[i][j] 表示从房间i，j出发，到达公主房间的最小值
                dp[i][j] = max(min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
};