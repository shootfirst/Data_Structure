// https://leetcode.cn/problems/array-partition/

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i+2<nums.length+1;i+=2) sum+=nums[i];
        return sum;
    }
}
