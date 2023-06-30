private void bubbleSort(int [] nums) {
    int len = nums.length;
    boolean swap = false;
    for (int i = 0; i < len; i++) {
        swap = false;
        for (int j = 0; j < len - i - 1; j++) {
            if (nums[j] > nums[j + 1]) {
                swap(nums, j, j + 1);
                swap = true;
            }
        }
        if (!swap) break;
    }
}
