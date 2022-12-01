class Solution {
    int ans = 0;
    int m;
    int n;
    char[][] grid;
    boolean [][] visit;
    int [][]direction = new int [][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        visit = new boolean[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && grid[i][j] == '1') {
                    ans ++;
                    dfs(i, j);
                }

            }
        }

        return ans;
    }

    public void dfs(int x, int y) {
        if (visit[x][y] || grid[x][y] == '0') return;
        visit[x][y] = true;
        for (int[] dir : direction) {
            x += dir[0];
            y += dir[1];
            if (!ifOut(x, y) && !visit[x][y])
                dfs(x, y);
            y -= dir[1];
            x -= dir[0];
        }
    }




    public boolean ifOut(int x, int y) {
        return x < 0 || y < 0 || x >= m || y >= n;
    }
}