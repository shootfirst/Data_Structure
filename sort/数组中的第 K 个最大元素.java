class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length, max = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            max = i;
            for (int j = i; j >= 0; j--) {
                if (nums[j] > nums[max]) max = j;
            }
            swap(nums, i, max);
        }

        return nums[len - k];
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
