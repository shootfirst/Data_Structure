// class Solution {
//     public int numSubarrayBoundedMax(int[] nums, int left, int right) {
//         int low=0,high=0,n=nums.length,cnt=0,max=-1;
//         while(high<n){
//             max=Math.max(max,nums[high]);
//             if(max<left||max>right){
//                 low=high+1;
//                 max=-1;
//             }
//             high++;
//             cnt+=high-low;
//         }
//         return cnt;
//     }
// }

public class Solution {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return lessEqualsThan(nums, right) - lessEqualsThan(nums, left - 1);
    }

    private int lessEqualsThan(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        // 循环不变量：nums[left..right] 里的所有元素都小于等于 k
        for (int left = 0, right = 0; right < len; right++) {
            if (nums[right] > k) {
                left = right + 1;
            }
            res += right - left;
        }
        return res;
    }
}