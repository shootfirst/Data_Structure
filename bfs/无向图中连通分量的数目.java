class Solution {
    List<Integer>[] g;
    int n;
    boolean [] visit;
    Queue<Integer> q = new LinkedList();
    public int countComponents(int n, int[][] edges) {
        g = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList();
        }
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        this.n = n;
        visit = new boolean[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                q.offer(i);
                visit[i] = true;
                bfs();
                ans++;
            }
        }

        return ans;
    }

    public void bfs() {
        if (q.isEmpty()) return;
        int i = q.poll();


        for (int v : g[i]) {
            if (!visit[v]) {
                // 这样才是正确的示范，假如先dfs再修改visit，会造成重复加入
                // 特别注意：在加入队列以后一定要将该结点标记为访问，否则会出现结果重复入队的情况
                visit[v] = true;
                q.offer(v);
            }

        }

        bfs();

    }
}