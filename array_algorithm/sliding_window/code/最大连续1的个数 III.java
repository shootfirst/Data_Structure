class Solution {
    public int longestOnes(int[] nums, int k) {
        List<Integer> arr=new ArrayList();
        int left=0,right=0,max=0,zero=0,turn=0;
        for(right=0;right<nums.length;right++){
            if(nums[right]==0){
                arr.add(right);
                if(k!=0){
                    k--;
                }else{
                    max=Math.max(max,right-left);
                    left=arr.get(turn++)+1;
                }
            }
        }
        return Math.max(max,right-left);
    }
}

//前缀和方法
// class Solution {
//     public int longestOnes(int[] nums, int k) {
//         int n = nums.length;
//         int left = 0, lsum = 0, rsum = 0;
//         int ans = 0;
//         for (int right = 0; right < n; ++right) {
//             rsum += 1 - nums[right];
//             while (lsum < rsum - k) {
//                 lsum += 1 - nums[left];
//                 ++left;
//             }
//             ans = Math.max(ans, right - left + 1);
//         }
//         return ans;
//     }
// }