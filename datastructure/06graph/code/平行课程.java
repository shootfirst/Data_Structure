class Solution {
    // https://leetcode.cn/problems/parallel-courses/
    public int minimumSemesters(int n, int[][] relations) {
        // 初始化邻接表和入度数组
        Set<Integer>[] g = new HashSet[n];

        for (int i = 0; i < n; i++) g[i] = new HashSet();

        int []inDegree = new int[n];
        for (int[] rel : relations) {
            inDegree[rel[1] - 1]++;
            g[rel[0] - 1].add(rel[1] - 1);
        }

        // 寻找入度为0的顶点加入到队列
        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        // 开始bfs
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int h = q.poll();
                for (int v : g[h]) {
                    inDegree[v]--;
                    if (inDegree[v] == 0) q.offer(v);
                }
            }

            step++;
        }

        // 判断是否有环
        for (int i : inDegree) if (i > 0) return -1;

        return step;
    }
}