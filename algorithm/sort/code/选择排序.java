private void selectionSort(int [] nums) {
    int len = nums.length;
    int min;
    for (int i = 0; i < len; i++) {
        min = i;
        for (int j = i; j < len; j++) {
            if (nums[j] < nums[min])
                min = j;
        }
        swap(nums, min, i);
    }
}