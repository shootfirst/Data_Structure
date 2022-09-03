class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left=0,right=0,max=0,n=s.length(),c=0;
        int [] cnt=new int[128];
        while(right<n){
            if(0==cnt[s.charAt(right++)]++) c++;
            while(c>2) if(--cnt[s.charAt(left++)]==0) c--;
            max=Math.max(max,right-left);
        }
        return max;
    }
}