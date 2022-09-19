class Solution {
    int uncolor = 0;
    int red = 1;
    int green = 2;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Set<Integer> [] g = new HashSet[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new HashSet();

        for (int i = 0; i < dislikes.length; i++) {
            g[dislikes[i][0]].add(dislikes[i][1]);
            g[dislikes[i][1]].add(dislikes[i][0]);
        }
        int [] color = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (color[i] == uncolor) {
                if (!dfs(i, g, color, red)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int i, Set<Integer> [] g, int [] color, int c) {
        color[i] = c;

        int nextc = c == red ? green : red;

        for(int a : g[i]) {
            if (color[a] == 0) {
                if (!dfs(a, g, color, nextc)) {
                    return false;
                }
            } else if (color[a] == c) {
                return false;
            }
        }

        return true;
    }
}