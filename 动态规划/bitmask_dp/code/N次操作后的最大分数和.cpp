class Solution {
public:
    int maxScore(vector<int>& nums) {
        int m = nums.size();
        vector<vector<int>> gcd_store(m, vector<int>(m));

        for(int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                gcd_store[i][j] = gcd(nums[i], nums[j]);
            }
        }

        // 表示数字是否删除, 为1为删除
        int mask = 1 << m;
        // 表示未删除数字状态为i时, 往下进行操作的最大分数
        vector<int> dp (1 << m, 0);

        for (int s = 3; s < mask; s++) {
            int t = __builtin_popcount(s);
            // 每次删两个数，所以为奇数个1点时候是非法的，我们不做处理
            if (t % 2 == 1) {
                continue;
            }
            
            for (int i = 0; i < m; i++) {
                if ((s >> i) & 1) {
                    for (int j = i + 1; j < m; j++) {
                        if ((s >> j) & 1) {
                            dp[s] = max(dp[s], dp[s ^ (1 << i) ^ (1 << j)] + t / 2 * gcd_store[i][j]);
                        }
                    }
                }
            }
        }
        return dp[dp.size() - 1];
    }
};
