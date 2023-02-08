class Solution {
    public int numSquares(int n) {
        int i = 1;
        for(; i * i < n; i++);

        if (i * i == n) return 1;
        // [1, i - 1], [0, n]
        int [] dp = new int[n + 1];

        for (int j = 1; j <= n; j++) dp[j] = j;

        for (int j = 2; j < i; j++) {
            for (int k = 1; k <= n; k++) {
                if (k >= j * j) dp[k] = Math.min(dp[k], dp[k - j * j] + 1);
            }
        }

        return dp[n];
    }

    public int numSquares(int n) {
        int i = 1;
        for(; i * i < n; i++);

        if (i * i == n) return 1;
        // [1, i - 1], [0, n]
        int [][] dp = new int[i - 1][n + 1];

        for (int j = 1; j <= n; j++) dp[0][j] = j;

        for (int j = 2; j < i; j++) {
            for (int k = 1; k <= n; k++) {
                if (k >= j * j) dp[j - 1][k] = Math.min(dp[j - 2][k], dp[j - 1][k - j * j] + 1);
                else dp[j - 1][k] = dp[j - 2][k];
            }
        }

        return dp[i - 2][n];
    }
}