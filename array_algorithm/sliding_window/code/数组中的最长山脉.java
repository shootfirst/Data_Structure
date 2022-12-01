class Solution {
    public int longestMountain(int[] arr) {
        if(arr.length<3) return 0;
        int flag=1,n=arr.length,left=0,right=1,max=0;

        while(right<n){
            while(right<n&&arr[left]>=arr[right]&&flag==1){
                left++;
                right++;
            }
            flag=0;
            if(right==n) break;
            while(right<n&&arr[right-1]<arr[right]) right++;
            if(right==n) break;
            if(arr[right-1]==arr[right]){
                left=right;
                right++;
                flag=1;
            }
            else{
                while(right<n&&arr[right-1]>arr[right]) right++;
                max=Math.max(max,right-left);
                left=right-1;
            }
        }
        return max;
    }
}