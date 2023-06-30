private void shellSort(int [] nums) {
    int len = nums.length;
    for (int gap = len / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < len; i++) {
            int store = nums[i];
            int j = i - gap;
            while (j >= 0 && nums[j] > store){
                nums[j + gap] = nums[j];
                j -= gap;
            }
            nums[j + gap] = store;
        }
    }
}