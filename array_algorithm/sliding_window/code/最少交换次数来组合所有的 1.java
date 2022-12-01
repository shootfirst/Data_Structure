// class Solution {
//     public int minSwaps(int[] data) {
//         int n=data.length,right=0,left=0,min=10000,cnt=0,c=0;
//         for(int i=0;i<n;i++) cnt+=data[i];
//         while(right<n){
//             while(right-left<cnt){
//                 if(data[right]==0) c++;
//                 right++;
//             }
//             min=Math.min(c,min);
//             if(data[right++]==0) c++;
//             if(data[left++]==0) c--;
//         }
//         return Math.min(c,min);
//     }
// }
class Solution {
    public int minSwaps(int[] data) {
        int cnt = 0;
        for(int num:data){
            if(num==1) cnt++;
        }
        int cur = 0;
        for(int i=0; i<cnt; i++){
            if(data[i]==1) cur++;
        }
        int maxOne = cur;
        for(int i=cnt; i<data.length; i++){
            cur += data[i]-data[i-cnt];
            maxOne = Math.max(maxOne, cur);
        }
        return cnt-maxOne;
    }
}