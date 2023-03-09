class Solution {
public:
    int countArrangement(int n) {
        int mask = 1 << n;
        vector<int> dp (mask, 0);
        dp[0] = 1;
        for (int m = 1; m < mask; m++) {
            int cnt = __builtin_popcount(m);
            for (int i = 0; i < n; i++) {
                if (((m >> i) & 1) && (cnt % (i + 1) == 0 || (i + 1) % cnt == 0)) {
                    dp[m] += dp[m - (1 << i)];
                }
            }
        }
        return dp[mask - 1];
    }
};