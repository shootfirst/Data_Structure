class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        List <Integer> loc=new ArrayList();
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(matrix[i][j]==0){
                    loc.add(i);
                    loc.add(j);
                }
        for(int i=0;i<loc.size();i+=2){
            for(int j=0;j<n;j++)
                matrix[loc.get(i)][j]=0;
            for(int j=0;j<m;j++)
                matrix[j][loc.get(i+1)]=0;
        }
    }
}