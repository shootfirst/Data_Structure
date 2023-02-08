class Solution {
public:
    int countArrangement(int n) {
        // mask第i位为1表示数字i + 1被已经被选取，dp[mask]表示状态为mask时可行方案总数
        vector<int> dp(1 << n);
        dp[0] = 1;

        for (int mask = 1; mask < (1 << n); mask++) {
            int num = __builtin_popcount(mask);
            for (int i = 0; i < n; i++) {
                if (mask & (1 << i) && (num % (i + 1) == 0 || (i + 1) % num == 0)) {
                    dp[mask] += dp[mask ^ (1 << i)];
                }
            }
        }

        return dp[(1 << n) - 1];


    }
};