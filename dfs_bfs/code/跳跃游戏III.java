class Solution {

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