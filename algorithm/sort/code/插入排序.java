private void insertSort(int [] nums) {
    int len = nums.length;
    for (int i = 0; i < len; i++) {
        int store = nums[i];
        int j = i - 1;
        while (j >= 0 && nums[j] > store){
            nums[j + 1] = nums[j];
            j--;
        }
        nums[j + 1] = store;
    }
}