class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int cnt=0,mark=0;
        for(int i=0;i<k;i++) cnt+=calories[i];
        if(cnt<lower) mark--;
        if(cnt>upper) mark++;
        for(int i=k;i<calories.length;i++){
            cnt+=calories[i]-calories[i-k];
            if(cnt<lower) mark--;
            if(cnt>upper) mark++;
        }
        return mark;
    }
}