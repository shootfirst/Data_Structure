class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int i=0,j=0,res=0;
        while(j<nums.length){
            if(j>0&&nums[j-1]>=nums[j]){
                i=j;
            }
            j++;
            res=Math.max(res,j-i);
        }
        return res;
    }
}