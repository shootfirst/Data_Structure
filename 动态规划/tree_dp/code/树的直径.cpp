class Solution {
public:
    int treeDiameter(vector<vector<int>>& edges) {
        int n = edges.size();

        vector<vector<int>> g(n + 1);

        for (const auto &e: edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }

        int ans = 0;
        dfs(0, -1, g, ans);
        return ans;
    }

private:
    int dfs(int u, int fa, const vector<vector<int> >& g, int& ans) {
        /*
          状态定义:
          dp[u][0] := 以 u 为根且包含 u 的最长链长度
          dp[u][1] := 以 u 为根且包含 u 的次长链长度
          
          答案:
          用 dp[u][0] + dp[u][1] 更新 ans
          
          初始化:
          dp[u][0] = 0   u 为叶子节点
          dp[u][1] = 0   u 为叶子节点
          
          状态转移:
          dp[u][0] = max(dp[v][0]) + 1          v 为 u 的子节点
          dp[u][1] = second_max(dp[v][0]) + 1   v 为 u 的子节点
          */
        int max1 = 0, max2 = 0;

        // 对所有子节点进行dfs
        for (int v : g[u]) {
            if (v != fa) {
                int t = dfs(v, u, g, ans) + 1;
                if (t > max1) {
                    max2 = max1;
                    max1 = t;
                } else if (max2 < t) {
                    max2 = t;
                }
            }
        }

        ans = max(ans, (max1 + max2));
        return max1;
    }
};