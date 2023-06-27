class Solution {
    // https://leetcode.cn/problems/target-sum/
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

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) sum += i;
        int n = (sum + target) / 2;

        if (Math.abs(target) > sum) return 0;
        if ((sum + target) % 2 == 1) return 0;

        int ans = 0;
        int [][] dp = new int [nums.length][n + 1];
        
        //初始化
        dp[0][0] = 1;
        if (nums[0] <= n) {
            dp[0][nums[0]] += 1;
            // 为啥不是这个
            // 对于测试用例 [0,0,0,0,0,0,0,0,1] 1，会出错，仔细体会
            // dp[0][nums[0]] = 1;
        }
        

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][n];
    }
}