class Solution {
public:
    int n;
    vector<vector<int>> tree;
    vector<bool> has;

    int dfs(int n, int p) {
        int ans = 0;
        if (has[n]) {
            ans += 2;
        }
        for (auto child : tree[n]) {
            if (child == p) {
                continue;
            }
            int res = dfs(child, n);
            if (res == 0) {
                continue;
            } else if (res > 0) {
                ans += res;
            }
        }
        if (ans != 0 && !has[n]) {
            ans += 2;
        }
        return ans;
    }
    int minTime(int n, vector<vector<int>>& edges, vector<bool>& hasApple) {
        this->n = n;
        tree = vector(n, vector<int>(0));
        for (auto& edge : edges) {
            tree[edge[0]].push_back(edge[1]);
            tree[edge[1]].push_back(edge[0]);
        }
        has = hasApple;
        int ans = dfs(0, -1);
        if (ans != 0) {
            ans -= 2;
        }
        return ans;
    }
};