class Solution {
    public int reversePairs(int[] nums) {
        if (nums.length < 2) return 0;
        int[] res = new int[nums.length];
        return mergeCnt(nums, 0, nums.length - 1, res);
    }

    public int mergeCnt(int[] nums, int start, int end, int[] res) {
        if (start == end) return 0;
        return mergeCnt(nums, start, (start + end) / 2, res)
                + mergeCnt(nums, (start + end) / 2 + 1, end, res) + merge(nums, start, end, res);
    }

    public int merge(int[] nums, int start, int end, int[] res) {
        int cnt = 0;
        int mid = (start + end) / 2;
        int left = start, right = mid + 1;
        int start2 = right;

        while(left <= mid && right <= end) {
            if (nums[left] <= nums[right]) {
                res[left + right - start2] = nums[left];
                left++;
            } else {
                cnt += mid - left + 1;
                res[left + right - start2] = nums[right];
                right++;
            }
        }



        while (left <= mid) {
            res[left + right - start2] = nums[left];
            left++;
        }

        while (right <= end) {
            res[left + right - start2] = nums[right];
            right++;
        }

        while (start <= end) {
            nums[start] = res[start];
            start++;
        }
        return cnt;

    }

    
}