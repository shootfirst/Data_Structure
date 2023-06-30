class Solution {
public:
// https://leetcode.cn/problems/shortest-path-visiting-all-nodes/
    int shortestPathLength(vector<vector<int>>& graph) {
        int n = graph.size();
    
        vector<vector<int>> d(n, vector<int>(n, n + 1));
        for (int i = 0; i < n; ++i) {
            for (int j: graph[i]) {
                d[i][j] = 1;
            }
        }
        // 使用 floyd 算法预处理出所有点对之间的最短路径长度
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }

        int mask = 1 << n;
        int dp[mask][n];
        memset(dp, 0x3f, sizeof(dp));
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = 0;
        }
        for (int m = 1; m < mask; m++) {
            for (int i = 0; i < n; i++) {
                if ((m & (1 << i)) != 0) {
                    for (int j = 0; j < n; j++) {
                        if ((m & (1 << j)) != 0) {
                            dp[m][i] = min(dp[m][i], dp[m - (1 << i)][j] + d[j][i]);
                        }
                    }
                }
            }
        }

        int ans = 1000000;
        for (int i = 0; i < n; i++) {
            ans = min(ans, dp[mask - 1][i]);
        }
        return ans;
    }
};