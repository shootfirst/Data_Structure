class Solution {
    public int search(ArrayReader reader, int target) {
        int l=0,r=1,m;
        for(;reader.get(r)<target;l=r,r*=2);
        while(l<r){
            m=l+(r-l)/2;
            if(reader.get(m)<target) l=m+1;
            else r=m;
        }
        return reader.get(l)==target?l:-1;
    }
}