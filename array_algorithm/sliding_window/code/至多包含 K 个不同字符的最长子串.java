class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left=0,right=0,max=0,n=s.length(),c=0;
        int [] cnt=new int[128];
        while(rightn){
            if(0==cnt[s.charAt(right++)]++) c++;
            while(ck) if(--cnt[s.charAt(left++)]==0) c--;
            max=Math.max(max,right-left);
        }
        return max;
    }
}