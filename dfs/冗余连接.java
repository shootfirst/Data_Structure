class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> g = new HashMap();
        Set<Integer> visit = new HashSet();

        for (int i = 0; i < edges.length; i++) {
            if (!g.containsKey(edges[i][0])) {
                g.put(edges[i][0], new ArrayList());
            }

            if (!g.containsKey(edges[i][1])) {
                g.put(edges[i][1], new ArrayList());
            }
            visit.clear();
            if (dfs(g, visit, edges[i][0], edges[i][1])) {
                return edges[i];
            } else {
                g.get(edges[i][0]).add(edges[i][1]);
                g.get(edges[i][1]).add(edges[i][0]);
            }
        }
        return null;
    }

    private boolean dfs(Map<Integer, List<Integer>> g, Set<Integer> visit, int i, int j) {
        visit.add(i);

        for (int a : g.get(i)) {
            if (a == j) return true;
            if (!visit.contains(a)) {
                if (dfs(g, visit, a, j)) {
                    return true;
                }
            }
        }

        return false;
    }
}