class Solution {
public:
// https://leetcode.cn/problems/burst-balloons/
    int maxCoins(vector<int>& nums) {
        int n = nums.size();
        vector<int> new_num(n + 2);
        new_num[0] = 1;
        new_num[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            new_num[i] = nums[i - 1];
        }
        if (n == 1) {
            return nums[0];
        }
        vector<vector<int>> dp(n + 2, vector<int>(n + 2));

        for (int j = 2; j <= n + 1; j++) {
            for (int i = j - 2; i >= 0; i--) {

                for (int k = i + 1; k < j; k++) {
                    // 理解公式精髓 
                    dp[i][j] = max(dp[i][j], dp[i][k] + new_num[i] * new_num[k] * new_num[j] + dp[k][j]);
                }

            }
        }
        return dp[0][n + 1];
    }
};
