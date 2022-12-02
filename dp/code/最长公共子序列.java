class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] nums1 = text1.toCharArray();
        char[] nums2 = text2.toCharArray();

        int m = nums1.length, n = nums2.length;

        int [][] dp = new int [m + 1][n + 1];

        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return res;
    }
}