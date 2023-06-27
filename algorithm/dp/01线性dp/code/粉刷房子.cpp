class Solution {
public:
// https://leetcode.cn/problems/JEj789/
    int minCost(vector<vector<int>>& costs) {
        int len = costs.size();
        vector<int> dp(3);
        for (int j = 0; j < 3; j++) {
            dp[j] = costs[0][j];
        }

        for (int i = 1; i < len; i++) {
            vector<int> newDp(3);
            for (int j = 0; j < 3; j++) {
                newDp[j] = min(dp[(j + 1) % 3], dp[(j + 2) % 3]) + costs[i][j];
            }
            dp = newDp;
        }

        return *min_element(dp.begin(), dp.end());
    }
};