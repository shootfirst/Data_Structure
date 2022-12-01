class Solution {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int [][] direction = new int [][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queueint[] q = new LinkedList();
        boolean [][] visit = new boolean[m][n];

        int cnt = 0;
        for (int i = 0; i  m; i++) {
            for (int j = 0; j  n; j++) {
                if (grid[i][j] == 1) cnt++;
                if (grid[i][j] == 2) {
                    q.add(new int [] {i, j});
                    visit[i][j] = true;
                }
            }
        }


        int step = 0;

        while (!q.isEmpty()) {
            if (cnt == 0) break;
            step++;
            int size = q.size();

            for (int k = 0; k  size; k++) {
                int[] rot = q.poll();
                visit[rot[0]][rot[1]] = true;

                for (int[] dir  direction) {
                    int x = rot[0] + dir[0];
                    int y = rot[1] + dir[1];

                    if (!ifOut(x, y, m, n) && !visit[x][y] && grid[x][y] == 1) {
                        visit[x][y] = true;
                        grid[x][y] = 2;
                        cnt--;
                        q.add(new int [] {x, y});
                    }
                }
            }
        }


        if (cnt  0) return -1;

        return step;
    }

    boolean ifOut(int x, int y, int m, int n) {
        return x  0  x = m  y  0  y = n;
    }
}