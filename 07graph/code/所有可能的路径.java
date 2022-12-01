class Solution {
    // dfs
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        if (graph == null || graph.length == 0) return ans;

        dfs(graph, 0, new ArrayList<>());
        return ans;
    }

    void dfs(int[][] graph, int node, List<Integer> path) {
        path.add(node);

        if (node == graph.length - 1) ans.add(new ArrayList(path));

        // 不存在环，我们可以大胆地这样走
        for (int i : graph[node]) {
            dfs(graph, i, path);
            path.remove(path.size() - 1);
        }
    }

    // bfs

    List<List<Integer>> ans = new ArrayList();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0) return ans;
        List<Integer> path = new ArrayList();
        Queue<List<Integer>> q = new LinkedList();
        path.add(0);
        q.add(path);
        int node;

        while (!q.isEmpty()) {
            path = q.poll();
            node = path.get(path.size() - 1);
            if (node == graph.length - 1) ans.add(path);

            for (int i : graph[node]) {
                List a = new ArrayList(path);
                a.add(i);
                q.add(a);
            }
        }

        return ans;
    }

}