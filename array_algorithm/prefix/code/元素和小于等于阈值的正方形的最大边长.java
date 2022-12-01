class Solution {
    private int [][] sum = new int[301][301];

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + mat[i][j];
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int k = 1; k <= Math.min(i + 1, j + 1); k++) {
                    if (getSum(i, j, k) <= threshold) {
                        ans = Math.max(ans, k);
                    }
                }
            }
        }

        return ans;
    }

    private int getSum(int r1, int c1, int len) {
        int r2 = r1 - len + 1;
        int c2 = c1 - len + 1;
        return sum[r1 + 1][c1 + 1] - sum[r1 + 1][c2] - sum[r2][c1 + 1] + sum[r2][c2];
    }
}