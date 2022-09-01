class Solution {
    public boolean isPerfectSquare(int num) {
        long l=0,h=1,m;
        for(;h*h<num;l=h,h*=2);
        while(l<=h){
            m=l+(h-l)/2;
            if(m*m==num) return true;
            else if(m*m>num) h=m-1;
            else l=m+1;
        }
        return false;
    }
}