class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0,right=n-1;
        int max=0;
        while(left<right){
            max=Math.max(max,Math.min(height[right],height[left])*(right-left));
            if(height[right]<height[left]) right--;
            else left++;
        }
        return max;
    }
}