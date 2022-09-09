class Solution {
    public String minNumber(int[] nums) {
        String ans = "";
        int len = nums.length;
        boolean change = false;
        for (int i = 0; i < len; i++) {
            change = false;
            for (int j = 0; j < len - 1 - i; j++) {
                if (("" + nums[j] + nums[j + 1]).compareTo("" + nums[j + 1] + nums[j]) > 0){
                    swap(nums, j, j + 1);
                    change = true;
                }
            }
            if (!change) break;
        }

        for (int i = 0; i < len; i++) {
            ans += nums[i];
        }

        return ans;
    }

    private void swap(int[] arr, int a, int b) {
        // if (arr[a] == 0) {
        //     arr[a] = arr[b];
        //     arr[b] = 0;
        // } else if (arr[b] == 0) {
        //     arr[b] = arr[a];
        //     arr[a] = 0;
        // } else {
        //     arr[a] ^= arr[b] ^= arr[a] ^= arr[b];
        // }

        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }



}