class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer>[] s = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            s[i] = new HashSet();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            s[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        int[] visit = new int [numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, s, visit)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, Set<Integer>[] s, int[] visit) {
        if (visit[i] == 1) return true;
        if (visit[i] == 2) return false;

        visit[i] = 1;

        for (int a : s[i]) {
            if (dfs(a, s, visit)) {
                return true;
            }
        }

        visit[i] = 2;
        return false;
    }
}