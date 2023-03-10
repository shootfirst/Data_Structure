class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList();

        int[] cnt = new int [numCourses];
        int[] ans = new int [numCourses];
        int k = 0;
        for (int i = 0; i < prerequisites.length; i++) {
            cnt[prerequisites[i][0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (cnt[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            ans[k] = q.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == ans[k]) {
                    cnt[prerequisites[i][0]]--;
                    if (cnt[prerequisites[i][0]] == 0) q.offer(prerequisites[i][0]);
                }
            }
            k++;
        }

        if (k != numCourses) return new int[0];

        return ans;
    }
}