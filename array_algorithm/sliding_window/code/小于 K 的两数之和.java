class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        if (nums.length < 2) {
            return -1;
        }
        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;

        int max = -1;

        while (left < right) {
            if (nums[left] + nums[right] >= k) {
                right--;
            } else {
                max = Math.max(max, nums[left] + nums[right]);
                left++;
            }
        }

        return max;


    }
}