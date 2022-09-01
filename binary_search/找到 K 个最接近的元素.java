class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List <Integer> ret=new ArrayList();
        int l=0,h=arr.length-1,m;
        while(l<h){
            m=l+(h-l)/2;
            if(arr[m]<x) l=m+1;
            else h=m;
        }
        l--;
        while(k>0){
            if(l>=0&&h<arr.length&&Math.abs(arr[l]-x)<=Math.abs(arr[h]-x)||l>=0&&h>=arr.length) l--;
            else h++;
            k--;
        }
        for(l=l+1;l<h;l++) ret.add(arr[l]);
        return ret;
    }
}