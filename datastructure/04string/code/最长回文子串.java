class Solution {
    public String longestPalindrome(String s) {
        int l=0,r=0,max=1;
        for(int i=0;i<s.length();i++){
            int len=1;
            for(int k=1;i-k>=0&&i+k<s.length();k++){
                if(s.charAt(i-k)==s.charAt(i+k)){
                    len+=2;
                    if(len>max){
                        l=i-k;
                        r=i+k;
                        max=len;
                    }
                }else break;
            }
            len=1;
        }
        for(int i=1;i<s.length();i++){
            int len=0;
            for(int k=1;i-k>=0&&i+k-1<s.length();k++){
                if(s.charAt(i-k)==s.charAt(i+k-1)){
                    len+=2;
                    if(len>max){
                        l=i-k;
                        r=i+k-1;
                        max=len;
                    }
                }
                else break;
            }
            len=0;
        }
        return s.substring(l,r+1);
    }
}
