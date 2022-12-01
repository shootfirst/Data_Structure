class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList();
        q.add(n);
        boolean[] visit = new boolean[n + 1];

        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int f = q.poll();
                for (int j = 1; j * j <= f; j++) {
                    if (j * j == f) return step;
                    if (!visit[f - j * j]) {
                        q.add(f - j * j);
                        visit[f - j * j] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}