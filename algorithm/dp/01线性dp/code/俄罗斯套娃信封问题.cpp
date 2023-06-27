class Solution {
public:
// https://leetcode.cn/problems/russian-doll-envelopes/
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        sort(envelopes.begin(), envelopes.end(), cmp);

        // dp[i] 表示以第i个长方形为底，最大能堆积的高度

        vector<int> dp(envelopes.size(), 1);

        for (int i = 1; i < envelopes.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < envelopes.size(); i++)  ans = max(ans, dp[i]);
        return ans;

    }

    // 排序算法无所谓，可以任选，只要可以体现大于就行
    static bool cmp(vector<int>&a, vector<int>&b) {
        return a[0] + a[1] < b[0] + b[1];
    }
};

// 优化

class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        if (envelopes.empty()) {
            return 0;
        }
        sort(envelopes.begin(), envelopes.end(), cmp);

        // dp[i] 表示长度为i的最长上升子序列的最后一个值

        vector<int> dp = {envelopes[0][1]};

        for (int i = 1; i < envelopes.size(); i++) {
            if (envelopes[i][1] > dp.back()) {
                dp.push_back(envelopes[i][1]);
            } else {
                auto it = lower_bound(dp.begin(), dp.end(), envelopes[i][1]);
                *it = envelopes[i][1];
            }
        }
        return dp.size();

    }

    static bool cmp(vector<int>&a, vector<int>&b) {
        return a[0] < b[0] || (a[0] == b[0] && a[1] > b[1]);
    }
    
};

