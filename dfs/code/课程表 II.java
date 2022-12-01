class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer>[] g = new HashSet[numCourses];

        for (int i = 0; i < numCourses; i++) {
            g[i] = new HashSet();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            g[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        int [] visit = new int[numCourses];

        List<Integer> res = new ArrayList();
        for (int i = 0; i < numCourses;i++) {
            if (dfs(g, visit, res, i)) {
                return new int [] {};
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }


    // 检测有向图是否有环
    private boolean dfs(Set<Integer>[] g, int[] visit, List<Integer> res, int i) {
        if (visit[i] == 1) return true;
        if (visit[i] == 2) return false;

        visit[i] = 1;

        for (int a : g[i]) {
            if (dfs(g, visit, res, a)) {
                return true;
            }
        }
        // 后序遍历
        res.add(i);
        visit[i] = 2;
        return false;
    }












}