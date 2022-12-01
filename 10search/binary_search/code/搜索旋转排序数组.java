class Solution {
    public int search(int[] nums, int target) {
        int l=0,h=nums.length-1,m;
        while(l<h){
            m=l+(h-l)/2;
            if(nums[m]>nums[h]) l=m+1;
            else h=m;
        }
        if(target>nums[nums.length-1]) return BinarySe(nums,0,l-1,target);
        else return BinarySe(nums,l,nums.length-1,target);
    }

    public int BinarySe(int[] nums,int l,int h,int target){
        int m;
        while(l<=h){
            m=l+(h-l)/2;
            if(nums[m]>target) h=m-1;
            else if(nums[m]<target) l=m+1;
            else return m;
        }
        return -1;
    }
}