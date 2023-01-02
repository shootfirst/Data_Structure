class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 持有股票手中最多现金和不持有股票手中最多现金
        int [][] dp = new int [n][2];
        dp[0][0] = - prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][1];
    }
}