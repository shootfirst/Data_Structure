class Solution {
    // https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int [][] dp = new int[n][2 * k + 1];

        for (int i = 1; i <= 2 * k; i += 2) {
            dp[0][i] = - prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 2 * k; j += 2) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + prices[i]);
            }
        }

        int max = 0;

        for (int i = 0; i <= 2 * k; i++) max = Math.max(max, dp[n - 1][i]);

        return max;
    }
}