class Solution {
    public int characterReplacement(String s, int k) {
        int max=0,left=0,right=0;
        int [] cnt=new int[26];
        while(right<s.length()){
            cnt[s.charAt(right)-'A']++;
            max=Math.max(max,cnt[s.charAt(right)-'A']);
            right++;
            if(right-left>max+k){
                cnt[s.charAt(left)-'A']--;
                left++;
            }

        }
        return right-left;
    }
}