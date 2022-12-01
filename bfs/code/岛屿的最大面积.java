class Solution {
    int [][] direction = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean [][]visit = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && grid[i][j] == 1) ans = Math.max(ans, bfs(grid, visit, i, j));
            }
        }
        return ans;
    }

    private int bfs(int[][] grid, boolean[][] visit, int i, int j) {
        int res = 1;
        visit[i][j] = true;
        Queue<int[]> q = new LinkedList();
        q.add(new int [] {i, j});

        while (!q.isEmpty()) {
            int [] idx = q.poll();
            for (int[] dir : direction) {
                int x = idx[0] + dir[0];
                int y = idx[1] + dir[1];
                if (!ifOut(x, y, visit.length, visit[0].length)
                        && !visit[x][y] && grid[x][y] == 1) {


                    q.offer(new int [] {x, y});
                    visit[x][y] = true;
                    res++;
                }
            }
        }

        return res;

    }

    private boolean ifOut(int i, int j, int m, int n) {
        return i < 0 || i >= m || j < 0 || j >= n;
    }
}