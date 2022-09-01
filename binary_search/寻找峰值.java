class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int l=0,h=nums.length-1,m;
        while(l<h){
            m=l+(h-l)/2;
            if(nums[m]<nums[m+1]) l=m+1;
            else h=m;
        }
        return l;
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        int left=0,right=nums.length-1;
        while(left+1<right){
            int mid=(right-left)/2+left;
            if(nums[mid-1]<nums[mid]){
                left=mid;
            }else{
                right=mid;
            }
        }
        return nums[left]>nums[right]?left:right;
    }
}
