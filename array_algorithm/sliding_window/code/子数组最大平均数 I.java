class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<k;i++) sum+=nums[i];
        int max=sum;
        for(int i=k;i<nums.length;i++){
            sum=sum+nums[i]-nums[i-k];
            max=Math.max(sum,max);
        }
        double m=(double)max;
        double kk=(double)k;
        return m/kk;
    }
}