class Solution {
public:
    vector<int> ans;
    vector<int> dp;
    vector<int> sz;
    vector<vector<int>> tree;

    void dfs(int u, int f) {
        dp[u] = 0;
        sz[u] = 1;
        for (auto v : tree[u]) {
            if (v != f) {
                dfs(v, u);
            }
        }
        for (auto v : tree[u]) {
            if (v != f) {
                dp[u] += sz[v] + dp[v];
                sz[u] += sz[v];
            }
        }
    }

    void reRoot(int u, int f) {
        ans[u] = dp[u];

        for (auto v : tree[u]) {
            if (v != f) {
                sz[u] -= sz[v];
                dp[u] -= sz[v] + dp[v];
                sz[v] += sz[u];
                dp[v] += sz[u] + dp[u];
                reRoot(v, u);
                dp[v] -= sz[u] + dp[u];
                sz[v] -= sz[u];
                dp[u] += sz[v] + dp[v];
                sz[u] += sz[v];
            }
        }
    }

    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        ans = vector(n, 0);
        dp = vector(n, 0);
        sz = vector(n, 0);
        tree = vector(n, vector<int>(0, 0));

        for (auto &edge : edges) {
            tree[edge[0]].push_back(edge[1]);
            tree[edge[1]].push_back(edge[0]);
        }

        dfs(0, -1);
        reRoot(0, -1);
        return ans;
    }
};