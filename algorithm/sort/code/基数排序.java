private void radixSort(int [] nums) {
    int len = nums.length;
    int max = Math.abs(nums[0]);
    for (int i : nums) {
        max = Math.max(max, Math.abs(i));
    }
    int maxdig = 0;
    do {
        maxdig++;
        max /= 10;
    } while (max > 0);
    int [] cnt = new int[19];
    int [] res = new int[len];
    int div = 10;
    for (int i = 0; i < maxdig; i++, div *= 10) {
        for (int j : nums) {
            int radix = j / div % 10 + 9;
            cnt[radix]++;
        }
        for (int j = 1; j < 19; j++) {
            cnt[j] += cnt[j - 1];
        }
        for (int j = len - 1; j >= 0; j--) {
            int radix = nums[j] / div % 10 + 9;
            res[--cnt[radix]] = nums[j];
        }
        System.arraycopy(res, 0, nums, 0, len);
        Arrays.fill(cnt, 0);
    }
}