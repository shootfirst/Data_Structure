// class Solution {
//     public String minWindow(String s1, String s2) {
//         int left=0,right=0,cnt=0,n=s1.length(),min=10000,l=s1.length()+1,r=0;
//         while(right<n){
//             if(s1.charAt(right)==s2.charAt(cnt)){
//                 right++;
//                 cnt++;
//             }
//             else if(right==left&&s1.charAt(right)!=s2.charAt(cnt)){
//                 right++;
//                 left++;
//             }
//             else{
//                 right++;
//             }
//             if(cnt==s2.length()){
//                 cnt=0;
//                 if(min>right-left){
//                     l=left;
//                     r=right;
//                     min=right-left;
//                 }
//             }
//         }
//         return l==s1.length()+1?"":s1.substring(l,r);
//     }
// }

class Solution {
    public String minWindow(String S, String T) {
        int[][] dp = new int[2][S.length()];

        for (int i = 0; i < S.length(); ++i)
            dp[0][i] = S.charAt(i) == T.charAt(0) ? i : -1;

        /*At time j when considering T[:j+1],
          the smallest window [s, e] where S[e] == T[j]
          is represented by dp[j & 1][e] = s, and the
          previous information of the smallest window
          [s, e] where S[e] == T[j-1] is stored as
          dp[~j & 1][e] = s.
        */
        for (int j = 1; j < T.length(); ++j) {
            int last = -1;
            Arrays.fill(dp[j & 1], -1);
            //Now we would like to calculate the candidate windows
            //"dp[j & 1]" for T[:j+1].  'last' is the last window seen.
            for (int i = 0; i < S.length(); ++i) {
                if (last >= 0 && S.charAt(i) == T.charAt(j))
                    dp[j & 1][i] = last;
                if (dp[~j & 1][i] >= 0)
                    last = dp[~j & 1][i];
            }
        }

        //Looking at the window data dp[~T.length & 1],
        //choose the smallest length window [s, e].
        int start = 0, end = S.length();
        for (int e = 0; e < S.length(); ++e) {
            int s = dp[~T.length() & 1][e];
            if (s >= 0 && e - s < end - start) {
                start = s;
                end = e;
            }
        }
        return end < S.length() ? S.substring(start, end+1) : "";
    }
}