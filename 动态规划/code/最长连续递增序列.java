class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) dp[i] = dp[i - 1] + 1;
            else dp[i] = 1;
        }

        int res = 0;

        for (int i = 0; i < n; i++) res = Math.max(res, dp[i]);

        return res;
    }
}