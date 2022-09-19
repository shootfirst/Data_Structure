class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++) g[i] = new ArrayList();

        for (int i = 0; i < edges.length; i++) {
            g[edges[i][0]].add(edges[i][1]);
            g[edges[i][1]].add(edges[i][0]);
        }

        int ans = 0;
        int [] visit = new int [n];

        for (int i = 0; i < n; i++) {
            if (visit[i] == 0) {
                dfs(i, visit, g);
                ans++;
            }
        }

        return ans;

    }

    private void dfs(int i, int[] visit, List<Integer>[] g) {
        visit[i] = 1;
        for (int point : g[i]) {
            if (visit[point] == 0) {
                dfs(point, visit, g);
            }
        }
    }
}