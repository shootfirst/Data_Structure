class Solution {
    // bfs
    public boolean canReach(int[] arr, int start) {
        boolean [] visit = new boolean [arr.length];

        Queue<Integer> q = new LinkedList();
        q.add(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            start = q.poll();
            if (arr[start] == 0) return true;
            if (start - arr[start] >= 0 && !visit[start - arr[start]]) {

                visit[start - arr[start]] = true;
                q.add(start - arr[start]);
            }
            if (start + arr[start] < arr.length && !visit[start + arr[start]]) {
                visit[start + arr[start]] = true;
                q.add(start + arr[start]);
            }

        }

        return false;
    }
}

class Solution {
    // dfs
    int[] arr_vec;
    boolean[] visit;
    public boolean canReach(int[] arr, int start) {
        arr_vec = arr;
        visit = new boolean[arr.length];
        return dfs(start);
    }

    private boolean dfs(int point) {
        if (point < 0 || point >= visit.length) return false;
        if (visit[point]) return false;
        visit[point] = true;
        if (arr_vec[point] == 0) return true;
        return dfs(point + arr_vec[point]) || dfs(point - arr_vec[point]);
    }
}