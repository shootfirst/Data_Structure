class Solution {
public:
// https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/
    int atMostNGivenDigitSet(vector<string>& digits, int n) {
        auto s = to_string(n);
        int m = s.length(), dp[m];
        memset(dp, -1, sizeof(dp)); 
        function<int(int, bool, bool)> f = [&](int index, bool limit, bool is_num) -> int {
            if (index == m) {
                return is_num;
            }

            if (!limit && is_num && dp[index] >= 0) {
                return dp[index];
            }
            int res = 0;
            if (!is_num) {
                res = f(index + 1, false, false);
            }
            auto up = limit ? s[index] : '9';
            for (auto d : digits) {
                if (d[0] > up) {
                    break;
                }
                res += f(index + 1, d[0] == up && limit, true);
            }
            if (!limit && is_num) {
                dp[index] = res;
            }
            return res;
        };
        return f(0, true, false);
    }
};