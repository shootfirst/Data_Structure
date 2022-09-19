class Solution {
    List<List<Integer>> ans = new LinkedList();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> path = new LinkedList();
        // 搜索起点不一定需要枚举到 n
        for (int i = 1; i <= n - k + 1; i++) dfs(i, path, n, k);
        return ans;
    }

    private void dfs(int i, LinkedList<Integer> path, int n, int k) {
        path.add(i);
        if (path.size() == k) {
            ans.add(new LinkedList(path));
            path.removeLast();
            return;
        }

        for (int j = i + 1; j <= n; j++) dfs(j, path, n, k);
        path.removeLast();
    }
}