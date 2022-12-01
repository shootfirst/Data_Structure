class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=0,n=nums.length;
        for(int a=0;a<n-2;a++){
            int b=a+1,c=n-1;
            while(b<c){
                while(c>b&&nums[a]+nums[b]+nums[c]>=target) c--;
                if(c>b) ans+=c-b;
                b++;
            }
        }
        return ans;
    }
}