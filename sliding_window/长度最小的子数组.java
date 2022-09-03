class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,right=0,min=nums.length+1,cnt=0;
        while(right<nums.length){
            cnt+=nums[right++];
            if(cnt>=target){
                while(cnt>=target) cnt-=nums[left++];
                min=Math.min(min,right-left+1);
            }
        }
        return min==nums.length+1?0:min;
    }
}