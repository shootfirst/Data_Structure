class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.size();

        if (n < 2) {
            return s;
        }
        vector<vector<bool>> dp (n, vector<bool>(n, true));

        for (int j = 1; j < n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[i][j] = s[i] == s[j] && dp[i + 1][j - 1];
            }
        }

        int max = 0;
        string ans = "";
        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i <= j; i++) {
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    ans = s.substr(i, j - i + 1);
                }
            }
        }
        return ans;
    }
};