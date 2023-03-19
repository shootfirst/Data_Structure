class Solution {
public:
    bool possibleToStamp(vector<vector<int>>& grid, int stampHeight, int stampWidth) {
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> sum (m + 1, vector<int>(n + 1, 0));
        vector<vector<int>> dif (m + 2, vector<int>(n + 2, 0));

        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + grid[i - 1][j - 1] - sum[i - 1][j - 1];
            }
        }

        for (int i = 1; i + stampHeight - 1 <= m; i ++) {
            for (int j = 1; j + stampWidth - 1 <= n; j++) {
                int p = i + stampHeight - 1, q = j + stampWidth - 1;
                if (sum[p][q] - sum[p][j - 1] - sum[i - 1][q] + sum[i - 1][j - 1] == 0) {
                    dif[p + 1][q + 1] += 1;
                    dif[i][j] += 1;
                    dif[i][q + 1] -= 1;
                    dif[p + 1][j] -= 1;
                }
            }
        }

        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j++) {
                dif[i][j] = dif[i][j] + dif[i][j - 1] + dif[i - 1][j] - dif[i - 1][j - 1];
                if (dif[i][j] == 0 && grid[i - 1][j - 1] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
};