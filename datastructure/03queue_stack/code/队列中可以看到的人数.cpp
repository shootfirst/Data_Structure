class Solution {
public:
// https://leetcode.cn/problems/number-of-visible-people-in-a-queue/
    vector<int> canSeePersonsCount(vector<int>& heights) {
        stack<int> s;
        vector<int> ans (heights.size(), 0);
        int n = heights.size();
        for (int i = 0; i < n; i++) {
            while (!s.empty() && heights[i] >= heights[s.top()]) {
                ans[s.top()]++;
                s.pop();
            }
            if (!s.empty() && heights[i] < heights[s.top()]) {
                ans[s.top()]++;
            }
            s.push(i);
        }
        return ans;
    }
};