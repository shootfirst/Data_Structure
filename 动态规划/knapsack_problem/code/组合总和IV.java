class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int [] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < n; j++) {
                if (i - nums[j] >= 0) dp[i] += dp[i - nums[j]];
            }
        }

        return dp[target];
    }

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        // base case
        dp[0][0] = 1;

        for (int i = 0; i <= target; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j][i] = dp[j - 1][i];
                if (i - nums[j - 1] >= 0) {
                    dp[j][i] += dp[n][i - nums[j - 1]];
                }
            }
        }
        return dp[n][target];
    }
}