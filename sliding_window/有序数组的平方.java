class Solution {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        if (length == 0) return new int[0];
        int[] ans = new int[length];

        int left = 0, right = length - 1, idx = length - 1;

        while (left < right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                ans[idx] = nums[right] * nums[right];
                right--;
                idx--;
            } else {
                ans[idx] = nums[left] * nums[left];
                left++;
                idx--;
            }
        }

        ans[0] = nums[left] * nums[left];

        return ans;
    }
}