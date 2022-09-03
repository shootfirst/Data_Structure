// class Solution {
//     public int minKBitFlips(int[] nums, int k) {
//         int left=0,right=0,n=nums.length,cnt=0;
//         while(right<n){
//             while(left<n&&nums[left]==1){
//                 left++;
//             }
//             if(left==n) return cnt;
//             for(right=left;right<n&&right<left+k;right++){
//                 nums[right]=1-nums[right];
//             }
//             right--;
//             cnt++;
//             if(right==n-1&&right-left+1!=k) return -1;
//         }
//         return cnt;
//     }
// }

class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= k && nums[i - k] > 1) {
                revCnt ^= 1;
                nums[i - k] -= 2; // 复原数组元素，若允许修改数组 nums，则可以省略
            }
            if (nums[i] == revCnt) {
                if (i + k > n) {
                    return -1;
                }
                ++ans;
                revCnt ^= 1;
                nums[i] += 2;
            }
        }
        return ans;
    }
}