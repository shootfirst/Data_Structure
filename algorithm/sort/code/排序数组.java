class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums);
        return nums;
    }

    private void quickSort(int [] nums, int start, int end) {
        if (start >= end) return;
        int mid = partition(nums, start, end);
        quickSort(nums, start, mid - 1);
        quickSort(nums, mid + 1, end);
    }

    private int partition(int [] nums, int start, int end) {
        int pivot = nums[start];
        int left = start + 1, right = end;

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
        swap(nums, start, right);
        return right;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}