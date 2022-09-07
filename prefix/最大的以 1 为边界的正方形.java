class Solution {
    private int[][] sum = new int[101][101];
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + grid[i][j];
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int k = 1; k <= Math.min(i + 1, j + 1); k++) {
                    if (k <= 2) {
                        if (getsum(i, j, k) == k * k) {
                            ans = Math.max(ans, k * k);
                        }
                    } else {
                        if (getsum(i, j, k) - getsum(i - 1, j - 1, k - 2) == 4 * k - 4) {
                            ans = Math.max(ans, k * k);
                        }
                    }

                }
            }
        }

        return ans;
    }

    private int getsum(int r1, int c1, int len) {
        int r2 = r1 - len + 1;
        int c2 = c1 - len + 1;
        return sum[r1 + 1][c1 + 1] - sum[r2][c1 + 1] - sum[r1 + 1][c2] + sum[r2][c2];
    }
}