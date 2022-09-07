class Solution {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] sum = new int [len + 1];

        for (int i = len - 1; i >= 0; i--) {
            sum[i] = sum[i + 1] + nums[i];
        }
        for (int i = 0; i < len; i++) {
            if (sum[0] - sum[i] == sum[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}