class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i : stones) sum += i;
        int n = sum / 2;

        int [] dp = new int[n + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = n; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[n];
    }
}