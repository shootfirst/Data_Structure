class Solution {
public:
// https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
    int strStr(string haystack, string needle) {
        if (haystack.size() < needle.size()) return -1;
        if (needle.size() == 0) return 0;
        return KMP(haystack, needle);
    }

    int KMP(string p,string s){
        int m=p.size(),n=s.size(),i=0,j=0;
        auto visit = getVisit(s);
        while(i<m&&j<n){
            if(j==-1||p[i]==s[j]){
                i++;
                j++;
            }else j=visit[j];
        }
        if(j<n) return -1;
        else return i-j;
    }

    vector<int> getVisit(string s) {
        int i = 0, j = -1;
        vector<int> visit (s.size());
        visit[0] = -1;
        while (i < s.size() - 1) {
            if (j == -1 || s[i] == s[j]) {
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