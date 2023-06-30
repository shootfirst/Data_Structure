class Solution {
public:
// https://leetcode.cn/problems/n-queens/
    vector<vector<string>> solveNQueens(int n) {
        int col[n];
        int slash1[2 * n - 1];
        int slash2[2 * n - 1];
        
        memset(col, 0, sizeof(col));
        memset(slash1, 0, sizeof(slash1));
        memset(slash2, 0, sizeof(slash2));

        vector<vector<int>> ans(0);
        vector<int>res(0);

        function<void(int)> dfs = [&](int i) {
            // 尝试在当前列放置
            if (i == n) {
                ans.push_back(res);
                return;
            }
            for (int j = 0; j < n; j++) {
                // 当前列，当先的两个斜线都没有放置（行已经排除了）
                if (col[j] == 0 && slash1[i + j] == 0 && slash2[i - j + n - 1] == 0) {
                    col[j] = 1;
                    slash1[i + j] = 1;
                    slash2[i - j + n - 1] = 1;
                    res.push_back(j);

                    dfs(i + 1);

                    col[j] = 0;
                    slash1[i + j] = 0;
                    slash2[i - j + n - 1] = 0;
                    res.pop_back();
                }
            }
            return;
        };

        dfs(0);

        auto convert2ans = [&](vector<vector<int>> ans) -> vector<vector<string>> {
            vector<vector<string>> res(0);
            for (auto one_ans : ans) {
                vector<string> one_res(0);
                for (auto pw : one_ans) {
                    string s = "";
                    for (int j = 0; j < pw; j++) {
                        s += ".";
                    }
                    s += "Q";
                    for (int j = pw + 1; j < n; j++) {
                        s += ".";
                    }
                    one_res.push_back(s);
                }
                res.push_back(one_res);
            }
            return res;
        };

        return convert2ans(ans);
    }
};