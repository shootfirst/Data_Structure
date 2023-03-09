class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] pre = new int[len + 1];
        int[] next = new int[len + 1];

        pre[0] = 1;
        for (int i = 1; i <= len; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }

        next[len] = 1;
        for (int i = len - 1; i >= 0; i--) {
            next[i] = next[i + 1] * nums[i];
        }

        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = pre[i] * next[i + 1];
        }

        return res;

    }
}