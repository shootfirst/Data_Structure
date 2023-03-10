class Solution {
    // bfs
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

class Solution {
    // dfs
    public int numSquares(int n) {
        return numSquaresHelper(n, new HashMap<Integer, Integer>());
    }

    private int numSquaresHelper(int n, HashMap<Integer, Integer> map) {
        // 记忆化
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            count = Math.min(count, numSquaresHelper(n - i * i, map) + 1);
        }
        map.put(n, count);
        return count;
    }
}