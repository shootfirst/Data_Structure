class Solution {
    public int minMoves(int[] nums, int limit) {

        int [] diff = new int [limit * 2 + 2];
        int len = nums.length;

        for (int i = 0, j = len - 1; i <= j; i++, j--) {
            diff[2] += 2;
            diff[2 * limit + 1] -= 2;
            diff[1 + Math.min(nums[i], nums[j])] -= 1;
            diff[limit + Math.max(nums[i], nums[j]) + 1] += 1;
            diff[nums[i] + nums[j]] -= 1;
            diff[nums[i] + nums[j] + 1] += 1;
        }

        int ans = len;
        for (int i = 2; i <= 2 * limit; i++) {
            diff[i] += diff[i - 1];
            ans = Math.min(ans, diff[i]);
        }

        return ans;
    }
}