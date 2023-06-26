class Solution {
public:
    // https://leetcode.cn/problems/shopping-offers/
    int shoppingOffers(vector<int>& price, vector<vector<int>>& special, vector<int>& needs) {
        map<vector<int>, int> mem{};
        vector<vector<int>> specials;
        int n = needs.size();

        for (auto sp : special) {
            int res = 0;
            for (int i = 0; i < n; i++) {
                res += sp[i] * price[i];
            }
            if (sp[n] < res) {
                specials.push_back(sp);
            }
        }

        function<int(vector<int>&)> f = [&](vector<int>& need) -> int {
            if (mem.count(need) != 0) {
                return mem[need];
            }

            int res = 0;
            for (int i = 0; i < n; i++) {
                res += price[i] * need[i];
            }

            for (auto sp : specials) {
                bool flag = false;
                for (int i = 0; i < n; i++) {
                    if (need[i] < sp[i]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
                vector<int> new_need(0);
                for (int i = 0; i < n; i++) {
                    new_need.push_back(need[i] - sp[i]);
                }
                res = min(res, f(new_need) + sp[n]);
            }

            mem[need] = res;
            return res;
        };

        return f(needs);
    }
};