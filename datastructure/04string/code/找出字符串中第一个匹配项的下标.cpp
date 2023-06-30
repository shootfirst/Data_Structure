class Solution {
public:
// https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
    int strStr(string haystack, string needle) {
        return KMP(haystack, needle);
    }
    int KMP(string p, string q) {
        auto visit = get_visit(q);
        int i = 0, j = 0, m = p.size(), n = q.size();
        while (i < m && j < n) {
            if (j == -1 || p[i] == q[j]) {
                i++;
                j++;
            } else {
                j = visit[j];
            }
        }
        return j == n ? i - j : -1;
    }
    vector<int> get_visit(string q) {
        int n = q.size();
        vector<int> visit(n, -1);
        int i = 0, j = -1;
        while (i < n - 1) {
            if (j == -1 || q[i] == q[j]) {
                i++;
                j++;
                visit[i] = j;
            } else {
                j = visit[j];
            }
        }
        return visit;
    }
};