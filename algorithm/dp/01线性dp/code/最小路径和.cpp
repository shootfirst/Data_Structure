// 从前往后

class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dp (m + 1, vector<int>(n + 1, INT_MAX));
        dp[0][1] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = grid[i - 1][j - 1] + min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
};


// 从后往前

class Solution {
public:
    int max = 1000000;
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dp (m + 1, vector<int>(n + 1, 0));

        for (int i = 0; i <= m; i++) dp[i][n] = max;
        for (int j = 0; j <= n; j++) dp[m][j] = max;

        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1)  {
                    continue;
                }
                dp[i][j] = min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }

        return dp[0][0];
    }
};