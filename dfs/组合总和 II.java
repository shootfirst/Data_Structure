class Solution {
    List<List<Integer>> ans = new ArrayList();
    int target;
    int[] candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;
        LinkedList<Integer> path = new LinkedList();
        Arrays.sort(candidates);
        int [] visit = new int [candidates.length];
        for (int i = 0; i < candidates.length; i++)
            dfs(i, 0, visit, path);
        return ans;
    }

    public void dfs(int start, int sum, int [] visit, LinkedList<Integer> path) {
        if (visit[start] == 1) return;

        // 剪枝
        if (sum + candidates[start] > target) return;

        // 剪枝
        if (start > 0 &&  visit[start - 1] == 0 && candidates[start - 1] == candidates[start]) return;
        path.add(candidates[start]);
        if (sum + candidates[start] == target) {
            ans.add(new LinkedList(path));
            path.removeLast();
            return;
        }
        visit[start] = 1;
        for (int i = start + 1; i < candidates.length; i++)
            dfs(i, sum + candidates[start], visit, path);
        visit[start] = 0;
        path.removeLast();


    }
}