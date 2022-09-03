class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if(s.length()<k) return 0;
        int n=s.length(),left=0,right=0,cnt=0;
        int [] let=new int[26];
        while(right<n){
            if(let[s.charAt(right)-'a']!=0) {
                for(;left<let[s.charAt(right)-'a'];left++) {
                    let[s.charAt(left)-'a']=0;
                }
            }
            let[s.charAt(right)-'a']=right+1;
            right++;
            if(right-left==k){
                cnt++;
                let[s.charAt(left)-'a']=0;
                left++;
            }
        }
        return cnt;
    }
}