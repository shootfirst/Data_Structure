class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length<2) return;
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                swap(nums,i,j);
                j++;
            }
        }
    }

    public void swap(int[] nums,int a,int b){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }
}
