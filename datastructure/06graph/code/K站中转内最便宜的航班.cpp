class Solution {
public:
    int max_num = 100000000;
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<vector<int>> dp (k + 2, vector<int>(n, max_num));
        dp[0][src] = 0;

        for (int i = 1; i <= k + 1; i++) {
            for (auto &flight : flights) {
                dp[i][flight[1]] = min(dp[i][flight[1]], dp[i - 1][flight[0]] + flight[2]);
            }
        }

        int ans = max_num;

        for (int i = 1; i <= k + 1; i++) {
            ans = min(ans, dp[i][dst]);
        }

        return ans < max_num ? ans : -1;
    }
};