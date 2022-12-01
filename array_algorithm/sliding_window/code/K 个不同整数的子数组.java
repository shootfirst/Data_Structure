class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDis(nums,k)-atMostKDis(nums,k-1);
    }
    public int atMostKDis(int[] nums,int k){
        int n=nums.length,left=0,right=0,cnt=0,ret=0;
        int []c=new int[n+1];
        while(right<n){
            if(0==c[nums[right++]]++) cnt++;
            while(cnt>k) if(0==--c[nums[left++]]) cnt--;
            ret+=right-left;
        }
        return ret;
    }
}