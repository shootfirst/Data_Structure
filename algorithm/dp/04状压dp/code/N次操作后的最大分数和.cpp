class Solution {
public:
    // https://leetcode.cn/problems/maximize-score-after-n-operations/
    int maxScore(vector<int>& nums) {
        int n = nums.size();
        int mask = 1 << n;

        vector<int> dp (mask, 0);

        for (int m = 3; m < mask; m++) {
            int cnt = __builtin_popcount(m);
            if (cnt % 2 == 1) continue;

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (((m >> i) & 1) && ((m >> j) & 1)) {
                        dp[m] = max(dp[m], dp[m - (1 << i) - (1 << j)] + cnt / 2 * gcd(nums[i], nums[j]));
                    }
                }
            }
        }
        return dp[mask - 1];
    }
};
