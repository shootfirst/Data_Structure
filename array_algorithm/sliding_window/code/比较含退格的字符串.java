class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n=s.length()-1,m=t.length()-1,sk=0,tk=0;
        while(n>=0||m>=0){
            while(n>=0){
                if(s.charAt(n)=='#'){
                    sk++;
                    n--;
                }
                else if(sk>0){
                    sk--;
                    n--;
                }
                else break;
            }
            while(m>=0){
                if(t.charAt(m)=='#'){
                    tk++;
                    m--;
                }
                else if(tk>0){
                    tk--;
                    m--;
                }
                else break;
            }
            if(m>=0&&n>=0){
                if(s.charAt(n)!=t.charAt(m)) return false;
            }else{
                if(n>=0||m>=0) return false;
            }
            m--;
            n--;
        }
        return true;
    }
}