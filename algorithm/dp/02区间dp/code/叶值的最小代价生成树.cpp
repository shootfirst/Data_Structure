class Solution {
public:
// https://leetcode.cn/problems/minimum-cost-tree-from-leaf-values/
    int mctFromLeafValues(vector<int>& arr) {
        int n = arr.size();
        int dp[n][n];
        memset(dp, 0x3f3f3f3f, sizeof(dp));
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        auto mx = [&](int left, int right) -> int {
            int res = INT_MIN;
            for (int i = left; i <= right; i++) {
                res = max(res, arr[i]);
            }
            return res;
        };

        for (int len = 2; len <= n; len++) { // 先枚举长度
            for (int i = 0; i + len - 1 < n; i++) {
                int left = i, right = i + len - 1;
                for (int mid = left; mid < right; mid++) {
                    dp[left][right] = min(dp[left][right], 
                        dp[left][mid] + dp[mid + 1][right] + mx(left, mid) * mx(mid + 1, right));
                }
            }
        }

        return dp[0][n - 1];
    }
};