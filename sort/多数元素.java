class Solution {
    public int majorityElement(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length / 2];
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = partition(nums, start, end);
        quickSort(nums, start, mid - 1);
        quickSort(nums, mid + 1, end);
    }

    public static int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int left = start + 1;
        int right = end;
        while (left < right) {
            while (left < right && nums[left] <= pivot) left++;
            while (left < right && nums[right] >= pivot) right--;

            if (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        if (left == right && nums[right] > pivot) {
            right--;
        }
        swap(nums, right, start);

        return right;
    }





    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}