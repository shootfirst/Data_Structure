private void countingSort(int [] nums) {
    int len = nums.length;
    int min = nums[0], max = nums[0];
    for (int i : nums) {
        min = Math.min(min, i);
        max = Math.max(max, i);
    }
    int [] cnt = new int [max - min + 1];
    int [] res = new int [len];
    for (int i = 0; i < len; i++) {
        cnt[nums[i] - min]++;
    }
    int pre = 0;
    for (int i = 0; i <= max - min; i++) {
        pre += cnt[i];
        cnt[i] = pre - cnt[i];
    }
    for (int i = 0; i < len; i++) {
        res[cnt[nums[i] - min]] = nums[i];
        cnt[nums[i] - min]++;
    }
    for (int i = 0; i < len; i++) {
        nums[i] = res[i];
    }
}