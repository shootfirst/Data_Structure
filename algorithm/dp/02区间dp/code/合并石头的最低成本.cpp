class Solution {
public:
// https://leetcode.cn/problems/minimum-cost-to-merge-stones/
    int mergeStones(vector<int>& stones, int k) {
        int n = stones.size();
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }

        int dp[n][n][k + 1]; // dp[left][right][st] = 合并石头[left, right]为st堆所需要的最小成本
        int sum[n];
        memset(dp, 0x3f3f3f3f, sizeof(dp));
        for (int i = 0; i < n; i++) {
            sum[i] = (i == 0 ? 0 : sum[i - 1]) + stones[i];
            dp[i][i][1] = 0;
        }

        // 确定区间长度
        for (int len = 2; len <= n; len++) {
            // 确定区间左右端点
            for (int left = 0; left + len - 1 < n; left++) {
                int right = left + len - 1;

                for (int st = 2; st <= k; st++) {

                    for (int mid = left; mid < right; mid++) {

                        dp[left][right][st] = 
                            min(dp[left][right][st], dp[left][mid][1] + dp[mid + 1][right][st - 1]);

                    }

                }

                dp[left][right][1] = dp[left][right][k] + sum[right] - (left == 0 ? 0 : sum[left - 1]);
            }
        }

        return dp[0][n - 1][1];
    }
};