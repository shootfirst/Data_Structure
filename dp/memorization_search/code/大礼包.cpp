class Solution {
private:
    // 用于记忆化搜索
    map<vector<int>, int> memo;
public:
    int shoppingOffers(vector<int>& price, vector<vector<int>>& special, vector<int>& needs) {
        int n = price.size();
        vector<vector<int>> filter_special {};
        for (auto & sp : special) {
            int count = 0;
            int total_price = 0;
            for (int i = 0; i < n; i++) {
                count += sp[i];
                total_price += price[i] * sp[i];
            }
            if (count > 0 && sp[n] < total_price) {
                filter_special.emplace_back(sp);
            }
        }

        return dfs(price, special, needs, n);
    }

    int dfs(vector<int>& price, vector<vector<int>>& special, vector<int> need, int n) {
        if (!memo.count(need)) {
            int min_price = 0;
            // 首先计算不购买任何大礼包的价格
            for (int i = 0; i < n; i++) {
                min_price += price[i] * need[i];
            }
            
            // 开始计算购买大礼包
            for (auto & sp : special) {
                // 判断能不能购买
                int sp_price = sp[n];
                vector<int> next_need{};
                for (int i = 0; i < n; i++) {
                    if (need[i] - sp[i] < 0) {
                        break;
                    }
                    next_need.emplace_back(need[i] - sp[i]);
                }
                // 可以购买
                if (next_need.size() == n) {
                    min_price = min(min_price, sp_price + dfs(price, special, next_need, n));
                }
            }
            memo[need] = min_price;

        }
        return memo[need];
    }
};