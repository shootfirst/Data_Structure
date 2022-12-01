class Solution {
    public int minOperations(int[] nums, int x) {
        int left=0,right=0,sum=0,max=-1;
        for(int i=0;i<nums.length;i++) sum+=nums[i];
        if(sum<x) return -1;
        int target=sum-x;
        sum=0;
        while(right<nums.length){
            if(sum<target) sum+=nums[right++];
            else if(sum>target) sum-=nums[left++];
            else{
                max=Math.max(max,right-left);
                sum+=nums[right++];
            }
        }
        while(sum>target) sum-=nums[left++];
        if(sum==target) max=Math.max(max,right-left);
        return max==-1?-1:nums.length-max;
    }
}