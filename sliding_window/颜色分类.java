class Solution {
    public void sortColors(int[] nums) {
        if(nums.length<2) return;
        int zero=-1,i=0,two=nums.length;
        while(i<two){
            if(nums[i]==0){
                zero++;
                swap(nums,zero,i);
                i++;
            }else if(nums[i]==1){
                i++;
            }else{
                two--;
                swap(nums,i,two);
            }
        }
    }
    public void swap(int[] nums,int a,int b){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }
}