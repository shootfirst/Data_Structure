// class Solution {
//     public int longestSubarray(int[] nums) {
//         int left=0,right=0,max=0,zero=0,c=1;
//         for(right=0;right<nums.length;right++){
//             if(nums[right]==0){
//                 if(c==1){
//                     c--;
//                 }else{
//                     max=Math.max(max,right-left-1);
//                     left=zero+1;
//                 }
//                 zero=right;
//             }
//         }
//         max=Math.max(max,right-left-1);
//         return max;
//     }
// }

class Solution {
    public int longestSubarray(int[] nums) {
        int cnt=0,max=0;
        for(int i=0,j=0;i<nums.length;i++){
            if(nums[i]==0) cnt++;
            while(cnt>1){
                if(nums[j++]==0) cnt--;
            }
            max=Math.max(max,i-j);
        }
        return max;
    }
}