class Solution {

    private final static Random random = new Random ();
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSort(int[] nums, int start, int end, int k) {
        int res = partition(nums, start, end);
        if (res == k) return nums[res];

        return res < k ? quickSort(nums, res + 1, end, k) : quickSort(nums, start, res - 1, k);
    }

    private int partition(int[] nums, int start, int end) {
        int rindex = random.nextInt(end - start + 1) + start;
        swap(nums, start, rindex);
        int left = start + 1;
        int right = end;
        while (left < right) {
            while (left < right && nums[left] < nums[start]) left++;
            while (left < right && nums[right] > nums[start]) right--;
            if (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        if (right == left && nums[right] > nums[start]) right--;
        swap(nums, start, right);
        return right;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}