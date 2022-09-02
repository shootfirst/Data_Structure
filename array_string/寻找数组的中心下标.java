class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length==1) return 0;
        int sum2=0,sum1=0,flag=0;
        for(int i=1;i<nums.length;i++) sum2+=nums[i];
        for(int i=0;i<nums.length;i++){
            if(sum1==sum2) return i;
            if(i==nums.length-1) break;
            sum1+=nums[i];
            sum2-=nums[i+1];
        }
        return -1;
    }
}