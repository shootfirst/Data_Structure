class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<3) return nums.length;
        int j=0;
        for(int i=1;i<nums.length;i++)
            if(j==0||nums[j-1]!=nums[i])
                nums[++j]=nums[i];
        return j+1;
    }
}