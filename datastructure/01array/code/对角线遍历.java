// https://leetcode.cn/problems/diagonal-traverse/

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int i=0,j=0,m=mat.length,n=mat[0].length,k=0;
        int [] ret=new int[m*n];
        while(k<m*n){
            while(i>=0&&j<n) ret[k++]=mat[i--][j++];
            if(j>=n){
                j--;
                i+=2;
                // j = j+1-1 i = i+1
            }else i++;
            while(i<m&&j>=0) ret[k++]=mat[i++][j--];
            if(i>=m){
                i--;
                j+=2;
            }else j++;
        }
        return ret;
    }
}
