class NumMatrix {

    private int matr[][] = new int[201][201];

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matr[i + 1][j + 1] = matr[i][j + 1] +
                        matr[i + 1][j] - matr[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matr[row2 + 1][col2 + 1] - matr[row1][col2 + 1] -
                matr[row2 + 1][col1] + matr[row1][col1];
    }
}