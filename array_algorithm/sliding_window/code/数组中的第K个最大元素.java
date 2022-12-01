class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left=0,right=nums.length-1,target=nums.length-k;
        while(true){
            int index=getIndex(nums,left,right);
            if(target==index) return nums[index];
            else if(target<index) right=index-1;
            else left=index+1;
        }
    }

    public int getIndex(int[] nums,int left,int right){
        int le=left+1,re=right;
        while(true){
            while(le<=re&&nums[le]<nums[left]) le++;
            while(le<=re&&nums[re]>nums[left]) re--;
            if(le>re) break;
            swap(nums,le,re);
            le++;
            re--;
        }
        swap(nums,left,re);
        return re;
    }

    public void swap(int[] nums,int a,int b){
        int swap=nums[a];
        nums[a]=nums[b];
        nums[b]=swap;
    }
}