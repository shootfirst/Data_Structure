class Solution {
    int ans = 0;
    Set<String> hash = new HashSet();
    public int maxUniqueSplit(String s) {
        dfs(s, 0);
        return ans;
    }

    private void dfs(String s, int pos) {
        if (pos == s.length()) {
            ans = Math.max(ans, hash.size());
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (hash.add(s.substring(pos, i + 1))) {
                dfs(s, i + 1);
                hash.remove(s.substring(pos, i + 1));
            }
        }


    }
}