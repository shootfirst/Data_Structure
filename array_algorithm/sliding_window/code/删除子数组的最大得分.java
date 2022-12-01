class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left=0,right=0,cnt=0,max=0;
        // 注意，此时间复杂度偏高，可以使用哈希表存储已经出现过的数据
        while(right<nums.length){
            int j=left;
            for(int i=left;i<right;i++) if(nums[i]==nums[right]) left=i+1;
            for(int i=j;i<left;i++) cnt-=nums[i];
            cnt+=nums[right++];
            max=Math.max(max,cnt);
        }
        return max;
    }
}