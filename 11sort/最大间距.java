class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;

        int len = nums.length;
        int max = 0;
        for (int i : nums) max = max < i ? i : max;

        int maxdig = 0;
        do {
            maxdig++;
            max /= 10;
        } while (max != 0);

        int [] cnt = new int[10];
        int [] res = new int[len];
        int div = 1;
        for (int i = 0; i < maxdig; i++, div *= 10) {

            for (int value : nums) {
                int radix = value / div % 10;
                cnt[radix]++;
            }
            for (int j = 1; j < 10; j++) {
                cnt[j] += cnt[j - 1];
            }



            for (int j = len - 1; j >= 0; j--) {
                int radix = nums[j] / div % 10;
                res[--cnt[radix]] = nums[j];
            }

            System.arraycopy(res, 0, nums, 0, len);

            Arrays.fill(cnt, 0);



        }

        int ans = 0;
        for (int i = 1; i < len; i++) {
            ans = Math.max(ans, nums[i] - nums[i - 1]);
        }
        return ans;
    }
}