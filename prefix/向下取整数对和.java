class Solution {
    private static final int MAX_LENGTH = 100000 + 1;
    private static final int MOD = 1000000000 + 7;
    int [] cnt = new int [MAX_LENGTH];
    int [] sum = new int [MAX_LENGTH];
    public int sumOfFlooredPairs(int[] nums) {
        for (int i : nums) {
            cnt[i]++;
        }
        for (int i = 1; i < MAX_LENGTH; i++) {
            sum[i] = sum[i - 1] + cnt[i];
        }

        int ans = 0;
        for (int i = 1; i < MAX_LENGTH; i++) {
            for (int j = i, k = 1; j < MAX_LENGTH; j += i, k++) {
                int left = j, right = Math.min(j + i - 1, MAX_LENGTH - 1);
                int total = sum[right] - sum[left - 1];
                ans += 1l * total * k % MOD * cnt[i] % MOD;
                ans %= MOD;
            }
        }
        return ans;
    }
}