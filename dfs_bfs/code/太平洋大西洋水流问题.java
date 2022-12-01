class Solution {
    int [][] direction = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
    List<List<Integer>> ans = new LinkedList();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean [][]visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bfs(heights, i, j);
            }
        }
        return ans;
    }

    private void bfs(int[][] heights, int i, int j) {
        Queue<int[]> q = new LinkedList();
        q.add(new int [] {i, j});
        boolean [][]visit = new boolean[heights.length][heights[0].length];
        boolean p = false, a = false;

        if (isPacific(i, j)) p = true;
        if (isAtlantic(i, j, heights.length, heights[0].length)) a = true;

        if (p && a) {
            List<Integer> res = new LinkedList();
            res.add(i);
            res.add(j);
            ans.add(res);
            return;
        }

        while (!q.isEmpty()) {
            int [] idx = q.poll();
            for (int[] dir : direction) {
                int x = idx[0] + dir[0];
                int y = idx[1] + dir[1];
                if (!ifOut(x, y, heights.length, heights[0].length)
                        && !visit[x][y] && heights[x][y] <= heights[idx[0]][idx[1]]) {

                    visit[x][y] = true;
                    if (isPacific(x, y)) p = true;
                    if (isAtlantic(x, y, heights.length, heights[0].length)) a = true;
                    if (p && a) {
                        List<Integer> res = new LinkedList();
                        res.add(i);
                        res.add(j);
                        ans.add(res);
                        return;
                    }

                    q.offer(new int [] {x, y});
                }
            }
        }

    }

    private boolean ifOut(int i, int j, int m, int n) {
        return i < 0 || i >= m || j < 0 || j >= n;
    }

    private boolean isPacific(int i, int j) {
        return i == 0 || j == 0;
    }

    private boolean isAtlantic(int i, int j, int m, int n) {
        return i == m - 1|| j == n - 1;
    }

}