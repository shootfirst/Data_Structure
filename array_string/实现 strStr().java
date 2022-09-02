// 实现kmp算法

class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()) return -1;
        if(needle.length()==0) return 0;
        return KMP(haystack,needle);
    }
    public int KMP(String p,String s){
        int m=p.length(),n=s.length(),i=0,j=0;
        int []visit=getVisit(s);
        while(i<m&&j<n){
            if(j==-1||p.charAt(i)==s.charAt(j)){
                i++;
                j++;
            }else j=visit[j];
        }
        if(j<n) return -1;
        else return i-j;
    }
    public int[] getVisit(String s){
        int [] visit=new int[s.length()];
        int p=visit[0]=-1;
        int j=0;
        while(j<visit.length-1){
            if(p==-1||s.charAt(j)==s.charAt(p)){
                j++;
                p++;
                visit[j]=p;
            }else p=visit[p];
        }
        return visit;
    }
}