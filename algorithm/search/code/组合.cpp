class Solution {
public:
// https://leetcode.cn/problems/combinations/
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> ans;

        function<void(vector<int>, int)> dfs = [&](vector<int> res, int index) {
            res.push_back(index);
            if (res.size() == k) {
                ans.push_back(res);
                return;
            }
            for (int i = index + 1; i <= n; i++) {
                dfs(res, i);
            }
            res.pop_back();
        };

        for (int i = 1; i <= n; i++) {
            dfs(vector<int>(0), i);
        }

        return ans;
    }

    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> ans;
        function<void(vector<int>, int)> dfs = [&](vector<int> res, int index) {
            if (index > n + 1) {
                return;
            }
            if (res.size() == k) {
                ans.push_back(res);
                return;
            }
            res.push_back(index);
            dfs(res, index + 1);
            res.pop_back();
            dfs(res, index + 1);
        };
        dfs(vector<int>(0), 1);
        return ans;
    }
};

