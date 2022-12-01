class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int cnt0 = 0, cnt1 = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') cnt0++;
                else cnt1++;
            }

            for (int i = m; i >= cnt0; i--) {
                for (int j = n; j >= cnt1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - cnt0][j - cnt1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}