class Solution {
public:
// https://leetcode.cn/problems/burst-balloons/
    int maxCoins(vector<int>& nums) {
        int n = nums.size();
        int ballons[n + 2];
        ballons[0] = 1;
        ballons[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            ballons[i + 1] = nums[i];
        }
        int dp[n + 2][n + 2]; // dp[left][right] = 戳破[left + 1, right - 1]中的所有气球获取的最大硬币数量
        memset(dp, 0, sizeof(dp));

        for (int len = 3; len <= n + 2; len++) {
            for (int left = 0; left + len - 1 < n + 2; left++) {
                int right = left + len - 1;

                for (int mid = left + 1; mid < right; mid ++) {

                    dp[left][right] = 
                        max(dp[left][right], dp[left][mid] + ballons[left] * ballons[mid] * ballons[right] + dp[mid][right]);

                }

            }
        }

        return dp[0][n + 1];
    }
};