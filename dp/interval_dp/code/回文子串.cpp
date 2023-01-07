class Solution {
public:
    int countSubstrings(string s) {
        int n = s.size();

        if (n < 2) {
            return 1;
        }
        vector<vector<bool>> dp (n, vector<bool>(n, true));

        // for (int i = 0; i < n; i++) {
        //     dp[i][i] = true;
        // }

        int ans = 0;
        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                if (s[i] == s[j] && (j - i <= 1 || dp[i + 1][j - 1])) {
                    ans++;
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return ans;
    }
};