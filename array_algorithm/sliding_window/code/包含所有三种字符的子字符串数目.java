class Solution {
    public int numberOfSubstrings(String s) {
        int[] cnt=new int[3];
        int n=s.length(),left=0,right=0,c=0,ret=0;
        while(right<n){
            if(0==cnt[s.charAt(right++)-'a']++) c++;
            while(c==3){
                ret+=n-right+1;
                if(0==--cnt[s.charAt(left++)-'a']) c--;
            }
        }
        return ret;
    }
}