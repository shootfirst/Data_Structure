class Solution {
    public int trap(int[] height) {
        int ans=0,left=0,right=height.length-1,lmax=0,rmax=0;
        while(left<right){
            lmax=Math.max(lmax,height[left]);
            rmax=Math.max(rmax,height[right]);
            if(height[left]<height[right]) ans+=lmax-height[left++];
            else ans+=rmax-height[right--];
        }
        return ans;
    }
}