class Solution {
    // https://leetcode.cn/problems/partition-equal-subset-sum/
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 2 == 1) return false;
        int n = sum / 2;

        int [] dp = new int[n + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = n; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[n] == n;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 2 == 1) return false;
        int n = sum / 2;
        int [][] dp = new int[nums.length][n + 1];
        //初始化
        for (int j = nums[0]; j <= n; j++) {
            dp[0][j] = nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            // 不能写成这样，仔细想想为什么
            // for (int j = nums[i]; j <= n; j++) {
            for (int j = 0; j <= n; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                
            }
        }
        return dp[nums.length - 1][n] == n;
    }
}

