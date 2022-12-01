class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n=nums.length;
        int[] ans=new int[n];
        if(a==0){
            if(b>=0)
                for(int i=0;i<n;i++)
                    ans[i]=nums[i]*b+c;
            else{
                for(int i=0;i<n;i++)
                    ans[i]=nums[n-1-i]*b+c;
            }
        }
        else{
            double l=-(double)b/2/a;
            int left=0,right=n-1;
            int k=0;
            while(left<=right){
                if(Math.abs(nums[left]-l)>Math.abs(nums[right]-l)){
                    ans[k++]=a*nums[left]*nums[left]+b*nums[left]+c;
                    left++;
                }else{
                    ans[k++]=a*nums[right]*nums[right]+b*nums[right]+c;
                    right--;
                }
            }
            if(a>0) reverse(ans);
        }
        return ans;
    }

    public void reverse(int[] ans){
        for(int i=0,j=ans.length-1;i<j;i++,j--){
            int swap=ans[i];
            ans[i]=ans[j];
            ans[j]=swap;
        }
    }
}