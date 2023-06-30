class Solution {
public:
// https://leetcode.cn/problems/parallel-courses-iii/
    int minimumTime(int n, vector<vector<int>>& relations, vector<int>& time) {
        vector<vector<int>> graph (n + 1, vector<int>(0));
        vector<vector<int>> rev (n + 1, vector<int>(0));
        vector<int> dp(n + 1, 0);
        vector<int> indegree(n + 1, 0);
        for (auto& relation : relations) {
            indegree[relation[1]]++;
            graph[relation[0]].push_back(relation[1]);
            rev[relation[1]].push_back(relation[0]);
        }

        queue<int> q;
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.push(i);
                dp[i] = time[i - 1];
            }
        }

        while (!q.empty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int node = q.front();
                q.pop();
                for (auto pre : rev[node]) {
                    dp[node] = max(dp[node], dp[pre] + time[node - 1]);
                }
                for (auto next : graph[node]) {
                    if (--indegree[next] == 0) {
                        q.push(next);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};