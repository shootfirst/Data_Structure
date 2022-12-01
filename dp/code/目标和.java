class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) sum += i;
        int n = (sum + target) / 2;

        if (Math.abs(target) > sum) return 0;
        if ((sum + target) % 2 == 1) return 0;

        int ans = 0;
        int [] dp = new int [n + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = n; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[n];
    }
}