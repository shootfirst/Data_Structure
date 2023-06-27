class Solution {
    // https://leetcode.cn/problems/coin-change/
    // 一维
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int n = coins.length;
        int[] dp = new int [amount + 1];

        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0) dp[j] = j / coins[0];
            else dp[j] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i])
                    dp[j] = Math.min(dp[j],
                            dp[j - coins[i]] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[j - coins[i]] + 1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    // 二维
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int n = coins.length;
        int[][] dp = new int [n][amount + 1];

        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0) dp[0][j] = j / coins[0];
            else dp[0][j] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.min(dp[i - 1][j],
                    dp[i][j - coins[i]] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i][j - coins[i]] + 1);
            }
        }

        return dp[n - 1][amount] == Integer.MAX_VALUE ? -1 : dp[n - 1][amount];
    }
}