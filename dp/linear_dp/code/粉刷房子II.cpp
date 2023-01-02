class Solution {
public:
    int minCostII(vector<vector<int>>& costs) {
        int k = costs[0].size();
        int len = costs.size();

        vector<int> dp(costs[0]);

        for (int i = 1; i < len; i++) {
            vector<int> dpNew(k);
            for (int j = 0; j < k; j++) {
                int prevMin = INT_MAX;
                for (int t = 0; t < k; t++) {
                    if (t != j) {
                        prevMin = min(prevMin, dp[t]);
                    }
                }
                dpNew[j] = prevMin + costs[i][j];
            }
            dp = move(dpNew);
        }
        return *min_element(dp.begin(), dp.end());
    }
};