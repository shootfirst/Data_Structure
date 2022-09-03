class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int left=0,right=0,n=arr.length,max=1;
        while(right<n-1){
            if (left == right) {
                if (arr[right] == arr[++right]) {
                    left++;
                }
            }
            else{
                if(arr[right-1]<arr[right]&&arr[right]>arr[right+1]||arr[right-1]>arr[right]&&arr[right]<arr[right+1]) right++;
                else left=right;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}

