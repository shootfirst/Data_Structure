class Solution {
    // https://leetcode.cn/problems/grumpy-bookstore-owner/
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int [] sum=new int[grumpy.length+1];
        int no=0;
        for(int i=0;i<grumpy.length;i++){
            if(grumpy[i]==0){
                no+=customers[i];
                sum[i+1]=sum[i];
            }else{
                sum[i+1]=sum[i]+customers[i];
            }
        }
        int max=0;
        for(int left=0;left<grumpy.length-minutes+1;left++){
            max=Math.max(max,sum[left+minutes]-sum[left]);
        }
        return max+no;
    }
}