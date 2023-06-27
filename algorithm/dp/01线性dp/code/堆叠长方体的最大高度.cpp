class Solution {
public:
// https://leetcode.cn/problems/maximum-height-by-stacking-cuboids/
    int maxHeight(vector<vector<int>>& cuboids) {

        for (auto &v : cuboids) sort(v.begin(), v.end());
        sort(cuboids.begin(), cuboids.end(), cmp);

        // dp[i] 表示以第i个长方体为底，最大能堆积的高度

        vector<int> dp(cuboids.size());

        dp[0] = cuboids[0][2];

        for (int i = 1; i < cuboids.size(); i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1] 
                    && cuboids[j][2] <= cuboids[i][2]) {

                    dp[i] = max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < cuboids.size(); i++)  ans = max(ans, dp[i]);
        return ans;

    }

    // 排序算法无所谓，可以任选，只要可以体现大于就行
    static bool cmp(vector<int>&a, vector<int>&b) {
        return a[0] + a[1] + a[2] < b[0] + b[1] + b[2];
    }
};