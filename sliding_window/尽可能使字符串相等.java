// class Solution {
//     public int equalSubstring(String s, String t, int maxCost) {
//         int left=0,right=0,n=t.length(),sum=0,max=0;
//         while(right<n){
//             maxCost-=Math.abs(s.charAt(right)-t.charAt(right));
//             sum++;
//             while(maxCost<0){
//                 maxCost+=Math.abs(s.charAt(left)-t.charAt(left));
//                 left++;
//                 sum--;
//             }
//             max=Math.max(max,sum);
//             right++;
//         }
//         return max;
//     }
// }

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left=0,right=0,n=t.length();
        while(right<n){
            maxCost-=Math.abs(s.charAt(right)-t.charAt(right++));
            if(maxCost<0) maxCost+=Math.abs(s.charAt(left)-t.charAt(left++));
        }
        return right-left;
    }
}