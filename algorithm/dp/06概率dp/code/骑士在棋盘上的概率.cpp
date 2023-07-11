class Solution {
public:
// https://leetcode.cn/problems/knight-probability-in-chessboard/
    double knightProbability(int n, int k, int row, int column) {
        vector<vector<int>> directs = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        vector<vector<vector<double>>> dp(k + 1, vector<vector<double>>(n, vector<double>(n, 0)));

        for (int step = 0; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (step == 0) {
                        dp[0][i][j] = 1;
                        continue;
                    }
                    for (auto dir :directs) {
                        int io = i + dir[0], jo = j + dir[1];
                        if (io >= 0 && io < n && jo >= 0 && jo < n) {
                            dp[step][io][jo] += dp[step - 1][i][j] / 8;
                        }
                    }

                }
            }
        }

        return dp[k][row][column];
    }
};