class Solution {
    public int totalFruit(int[] fruits) {
        int left=0,right=0,max=0,n=fruits.length,c=0;
        int [] cnt=new int[n];
        while(right<n){
            if(0==cnt[fruits[right++]]++) c++;
            while(c>2) if(--cnt[fruits[left++]]==0) c--;
            max=Math.max(max,right-left);
        }
        return max;
    }
}