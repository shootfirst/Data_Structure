class Solution {
public:
    // https://leetcode.cn/problems/number-of-digit-one/
    string s;
    vector<vector<int>> mem;
    int countDigitOne(int n) {
        s = to_string(n);

        mem = vector(s.size(), vector(10, -1));

        return memSch(0, true, 0);
    }

    int memSch(int i, bool limit, int oneCnt) {
        if (i == s.size()) return oneCnt;
        if (!limit && mem[i][oneCnt] != -1) return mem[i][oneCnt];
        int up = limit ? s[i] - '0' : 9;
        int res = 0;
        for (int d = 0; d <= up; d++) {
            res += memSch(i + 1, limit && d == up, oneCnt + (d == 1));
        }
        if (!limit) mem[i][oneCnt] = res;
        return res;
    }
};