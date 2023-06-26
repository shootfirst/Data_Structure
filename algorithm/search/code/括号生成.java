class Solution {
    // https://leetcode.cn/problems/generate-parentheses/
    int left = 0;
    int right = 0;
    int n;
    List<String> ans = new ArrayList();
    public List<String> generateParenthesis(int n) {
        this.n = n;
        StringBuilder s = new StringBuilder();
        dfs(s);
        return ans;
    }

    private void dfs(StringBuilder s) {
        if (left == n && right == n) {
            ans.add(s.toString());
            return;
        }
        // 满足加左括号条件
        if (left < n) {
            s.append("(");
            left++;
            dfs(s);
            left--;
            s.deleteCharAt(s.length() - 1);
        }
        // 满足加右括号条件
        if (right < left) {
            s.append(")");
            right++;
            dfs(s);
            right--;
            s.deleteCharAt(s.length() - 1);
        }
    }
}