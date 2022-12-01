class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length,left=0,right=0,cnt=0,u=1;
        while(right<n){
            u*=nums[right];
            while(u>=k&&left!=right){
                u/=nums[left++];
            }
            if(u>=k&&left==right){
                left++;
                right++;
                u=1;
            }
            else{
                right++;
                cnt+=right-left;
            }
        }
        return cnt;
    }
}