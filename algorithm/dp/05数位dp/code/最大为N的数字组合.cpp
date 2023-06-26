class Solution {
public:
    // https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/
    string s;
    vector<int> dd;
    vector<int> mem;
    int atMostNGivenDigitSet(vector<string>& digits, int n) {
        s = to_string(n);
        for (string &s : digits) {
            dd.push_back(stoi(s));
        }
        mem = vector(s.size(), -1);
        return memS(0, true, false);
    }

    int memS(int index, bool limit, bool isNum) {
        if (index == s.size()) return isNum;
        if (!limit && mem[index] != -1 && isNum) return mem[index];
        int up = limit ? s[index] - '0' : 9;
        int res = isNum ? 0 : memS(index + 1, false, false);
        for (int d : dd) {
            if (d <= up) {
                res += memS(index + 1, limit && d == up, true);
            }
        }
        if (!limit && isNum) mem[index] = res;
        return res;
    }
};