class NumArray {
    private static final int MAX_LENGTH = 10000 + 5;
    private int[] sum = new int[MAX_LENGTH];

    public NumArray(int[] nums) {
        int len = nums.length;
        sum[0] = 0;
        for (int i = 1; i <= len; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}