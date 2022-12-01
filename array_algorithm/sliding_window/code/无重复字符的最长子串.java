class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<2) return s.length();
        int left=0,right=0,max=0;
        while(right<s.length()){
            for(int i=left;i<right;i++){
                if(s.charAt(i)==s.charAt(right)){
                    left=i+1;
                    break;
                }
            }
            right++;
            max=Math.max(max,right-left);
        }
        return max;
    }
}