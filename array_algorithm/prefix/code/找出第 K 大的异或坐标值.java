class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] xor = new int [m + 1][n + 1];

        List<Integer> q = new ArrayList();

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                xor[i][j] = xor[i - 1][j] ^ xor[i][j - 1] ^ xor[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                q.add(xor[i][j]);
            }
        }

        Collections.sort(q, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });

        return q.get(k - 1);


    }
}