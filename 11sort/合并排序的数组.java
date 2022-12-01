class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int[] C = new int [m];
        for (int i = 0; i < m; i++) {
            C[i] = A[i];
        }

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (C[i] < B[j]) {
                A[i + j] = C[i];
                i++;
            } else {
                A[i + j] = B[j];
                j++;
            }
        }

        for (; i < m; i++) {
            A[i + j] = C[i];
        }

        for (; j < n; j++) {
            A[i + j] = B[j];
        }
    }
}