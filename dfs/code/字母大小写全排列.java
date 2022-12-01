class Solution {
    List<String> ans = new ArrayList();
    public List<String> letterCasePermutation(String s) {
        if (s.length() == 0) return ans;
        StringBuilder res = new StringBuilder();
        dfs(s, res, 0);
        return ans;
    }

    private void dfs(String s, StringBuilder res, int pos) {
        int old = pos;
        while (pos < s.length() && !Character.isLetter(s.charAt(pos))) {
            res.append(s.charAt(pos));
            pos++;
        }
        if (pos == s.length()) {
            ans.add(res.toString());
            while (res.length() > 0 && !Character.isLetter(res.charAt(res.length() - 1)))
                res.deleteCharAt(res.length() - 1);
            return;

        } else if (Character.isLowerCase(s.charAt(pos))) {
            res.append(s.charAt(pos));
            dfs(s, res, pos + 1);
            res.deleteCharAt(pos);

            res.append(Character.toUpperCase(s.charAt(pos)));
            dfs(s, res, pos + 1);
            while (pos >= old) {
                res.deleteCharAt(pos);
                pos--;
            }
        } else {
            res.append(s.charAt(pos));
            dfs(s, res, pos + 1);
            res.deleteCharAt(pos);

            res.append(Character.toLowerCase(s.charAt(pos)));
            dfs(s, res, pos + 1);
            while (pos >= old) {
                res.deleteCharAt(pos);
                pos--;
            }
        }
    }
}