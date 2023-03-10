class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int l=0,r=cardPoints.length,sum=0;
        for(;l<k;l++) sum+=cardPoints[l];
        l--;
        int max=sum;
        for(;l>=0;l--){
            sum=sum+cardPoints[--r]-cardPoints[l];
            max=Math.max(max,sum);
        }
        return max;
    }
}