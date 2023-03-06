class Solution {
public:
    double largestSumOfAverages(vector<int>& nums, int k) {
        int len = nums.size();
        vector<double> prefix(len + 1);
        for (int i = 0; i < len; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        vector<vector<double>> dp(len + 1, vector<double>(k + 1));
        for (int i = 1; i <= len; i++) {
            dp[i][1] = prefix[i] / i;
        }
        for (int j = 2; j <= k; j++) {
            for (int i = j; i <= len; i++) {
                for (int m = j - 1; m < i; m++) {
                    dp[i][j] = max(dp[m][j - 1] + (prefix[i] - prefix[m]) / (i - m), dp[i][j]);
                }
            }
        }
        return dp[len][k];
    }
};