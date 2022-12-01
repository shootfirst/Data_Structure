class Solution {
    public int mySqrt(int x) {
        if(x==0||x==1) return x;
        int l=0,h=x-1,m=0;
        while(l<=h){
            m=l+(h-l)/2;
            long v=(long)m*m;
            if(v==x) return m;
            else if(v>x) h=m-1;
            else l=m+1;
        }
        return m*m<=x?m:m-1;
    }
}