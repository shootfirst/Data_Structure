class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int left=0,right=nums[n-1]-nums[0];
        while(left<right){
            int mid=getMid(left,right);
            if(get(mid,nums)>=k) right=mid-1;
            else left=mid;
        }
        return left;
    }
    public int getMid(int left,int right){
        if((left+right)%2==0) return left+(right-left)/2;
        else return left+(right-left+1)/2;
    }
    public int get(int mid,int nums[]){
        int left=0,right=0,n=nums.length,cnt=0;
        while(right<n){
            if(nums[right]-nums[left]<mid){
                cnt+=right-left;
                right++;
            }else{
                left++;
            }
        }
        return cnt;
    }
}