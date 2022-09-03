class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left=0,right=0,max=0,zero=0,c=1;
        for(right=0;right<nums.length;right++){
            if(nums[right]==0){
                if(c==1){
                    c--;
                }else{
                    max=Math.max(max,right-left);
                    left=zero+1;
                }
                zero=right;
            }
        }
        max=Math.max(max,right-left);
        return max;
    }
}

// class Solution{
//     public int findMaxConsecutiveOnes(int[] nums) {
//         int l = 0, r = 0;
//         int ans = 0, n = nums.length;
//         //true表示还未反转
//         boolean flag = true;
//         int t = 0;
//         while (r < n) {
//             if (nums[r] == 0) {
//                 if (flag)
//                     flag = false;
//                 else {
//                     ans = Math.max(ans, r - l);
//                     l = t + 1;
//                 }
//                 t = r;
//             }
//             r++;
//         }
//         ans = Math.max(ans, r - l);
//         return ans;
//     }
// }