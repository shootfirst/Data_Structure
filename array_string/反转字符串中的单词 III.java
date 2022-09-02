class Solution {
    public String reverseWords(String s) {
        int l=0,r=0,len=s.length();
        char []c=s.toCharArray();
        while(r<len){
            while(r<len&&c[r]!=' ') r++;
            r--;
            int high=r+2;
            while(l<r){
                char tmp=c[l];
                c[l++]=c[r];
                c[r--]=tmp;
            }
            r=l=high;
        }
        StringBuilder s1=new StringBuilder();
        for(char cc:c) s1.append(cc);
        return s1.toString();
    }
}