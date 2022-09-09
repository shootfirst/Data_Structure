class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        for (int i = 0; i < len - cnt; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < len - 1 - cnt; j++)
                    swap(nums, j, j + 1);
                cnt++;
                i--;
            }

        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}