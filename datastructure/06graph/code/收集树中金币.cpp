class Solution {
public:
// https://leetcode.cn/problems/collect-coins-in-a-tree/
    int collectTheCoins(vector<int>& coins, vector<vector<int>>& edges) {
        // 1.建🌲
        int n = coins.size();
        vector<vector<int>> tree (n, vector<int>(0));
        vector<int> degree(n, 0);
        for (auto& edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            tree[edge[0]].push_back(edge[1]);
            tree[edge[1]].push_back(edge[0]);
        }

        // 2.斩断所有子树没有金币点节点
        deque<int> q;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1 && coins[i] == 0) {
                q.push_back(i);
            }
        }
        while (!q.empty()) {
            auto node = q.front();
            q.pop_front();
            for (auto neigh : tree[node]) {
                if (--degree[neigh] == 1 && coins[neigh] == 0) {
                    q.push_back(neigh);
                }
            }
        }
        // 3.找出有金币的叶子节点
        vector<int> time(n, -1);
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1 && coins[i] == 1) {
                q.push_back(i);
                time[i] = 0;
            }
        }
        if (q.size() <= 1) return 0;
        // 4.计算层数
        while (!q.empty()) {
            auto node = q.front();
            q.pop_front();
            for (auto neigh : tree[node]) {
                if (--degree[neigh] == 1) {
                    time[neigh] = time[node] + 1; 
                    q.push_back(neigh);
                }
            }
        }
        // 5.遍历所有层数大于等于2的节点即可
        int ans = 0;
        for (auto &e: edges)
            if (time[e[0]] >= 2 && time[e[1]] >= 2)
                ans += 2;
        return ans;
    }
};