class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int [][]matrix = new int [n + 1][n + 1];
        int [] dest = new int[n + 1];
        int [] visit = new int[n + 1];

        for (int i = 0; i <= n; i++) Arrays.fill(matrix[i], Integer.MAX_VALUE);
        Arrays.fill(dest, Integer.MAX_VALUE);
        Arrays.fill(visit, 0);

        for (int i = 0; i < times.length; i++) matrix[times[i][0]][times[i][1]] = times[i][2];
        for (int i = 1; i <= n; i++) dest[i] = matrix[k][i];

        dest[k] = 0;
        visit[k] = 1;

        for (int j = 1; j < n; j++) {
            int min = Integer.MAX_VALUE, idx = -1;
            for (int i = 1; i <= n; i++) {
                if(min > dest[i] && visit[i] == 0) {
                    min = dest[i];
                    idx = i;
                }
            }

            if (idx == -1) return -1;
            visit[idx] = 1;

            for (int i = 1; i <= n; i++) {
                if (visit[i] == 0 && matrix[idx][i] != Integer.MAX_VALUE &&
                        dest[i] > dest[idx] + matrix[idx][i])

                    dest[i] = dest[idx] + matrix[idx][i];
            }


        }

        int max = 0;

        for (int i = 1; i <= n; i++) max = Math.max(max, dest[i]);

        return max;
    }
}