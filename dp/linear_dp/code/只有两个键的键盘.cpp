class Solution {
public:
    int minSteps(int n) {
        vector<int> dp (n + 1);

        for (int i = 2; i <= n; i++) {
            dp[i] = INT_MAX;
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    dp[i] = min(dp[j] + i / j, dp[i]);
                    dp[i] = min(dp[i / j] + j, dp[i]);
                }
            }
        }
        return dp[n];
    }
};