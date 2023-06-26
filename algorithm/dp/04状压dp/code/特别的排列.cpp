class Solution {
public:
    // https://leetcode.cn/problems/special-permutations/
    int specialPerm(vector<int>& nums) {
        int n = nums.size();
        int mask = 1 << n;
        int dp[mask][n]; //dp[m][i] 已选m，最后一个选的是i
        memset(dp, 0, sizeof(dp));
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = 1;
        }

        for (int m = 1; m < mask; m++) {

            for (int i = 0; i < n; i++) {
                if ((m & (1 << i)) != 0) {

                    for (int j = 0; j < n; j++) {
                        if ((m & (1 << j)) == 0 && (nums[j] % nums[i] == 0 || nums[i] % nums[j] == 0)) {

                            dp[m | (1 << j)][j] = (dp[m | (1 << j)][j] + dp[m][i]) % 1000000007;

                        }
                    }

                }
            } 

        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + dp[mask - 1][i]) % 1000000007;
        }
        return ans;
    }
};