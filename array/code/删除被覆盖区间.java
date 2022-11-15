class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        if(intervals.length==1) return 1;
        int count=0;
        Arrays.sort(intervals,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        for(int i=0;i<intervals.length-1;i++){
            if(intervals[i][1]>=intervals[i+1][1]){
                intervals[i+1][0]=intervals[i][0];
                intervals[i+1][1]=intervals[i][1];
                count++;
            }
        }
        return intervals.length-count;
    }
}