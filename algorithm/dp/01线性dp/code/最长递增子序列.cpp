class Solution {
public:
// https://leetcode.cn/problems/longest-increasing-subsequence/
    int lengthOfLIS(vector<int>& nums) {
        vector<int> dp(nums.size(), 1);

        for (int i = 1; i < nums.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int i : dp) {
            ans = max(ans, i);
        }
        return ans;

    }
};

// 优化
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> dp = {nums[0]};

        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] > dp.back()) {
                dp.push_back(nums[i]);
            } else {
                auto it = lower_bound(dp.begin(), dp.end(), nums[i]);
                *it = nums[i];
            }
        }
        return dp.size();

    }
};

