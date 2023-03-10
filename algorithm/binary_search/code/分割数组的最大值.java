class Solution {
    public int splitArray(int[] nums, int m) {
        int l=0,h=0;
        for(int num:nums){
            h+=num;
            l=Math.max(l,num);
        }
        while(l<h){
            int mid=l+(h-l)/2;
            if(count(nums,mid)>m) l=mid+1;
            else h=mid;
        }
        return l;
    }
    public int count(int[] nums,int mid){
        int sum=0,cnt=1;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]>mid){
                cnt++;
                sum=nums[i];
            }else
                sum+=nums[i];
        }
        return cnt;
    }
}
