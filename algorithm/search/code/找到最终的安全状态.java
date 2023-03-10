class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> ans = new ArrayList();
        int [] visit = new int[n];
        for (int i = 0; i < n; i++) {
            if (!dfs(graph, visit, i)) ans.add(i);
        }
        return ans;
    }

    private boolean dfs(int[][] graph, int[] visit, int i) {
        if (visit[i] != 0) return visit[i] == 1 ? true : false;
        visit[i] = 1;
        for (int a : graph[i]) {
            if (dfs(graph, visit, a)) {
                return true;
            }
        }

        visit[i] = -1;
        return false;
    }
}