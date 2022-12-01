class Solution {
    int[] candidates;
    int target;
    List<List<Integer>> ans = new LinkedList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        LinkedList<Integer> path = new LinkedList();
        Arrays.sort(candidates);

        for (int i = 0; i < candidates.length; i++) dfs(path, 0, i, i);
        return ans;
    }

    private void dfs(LinkedList<Integer> path, int sum, int begin, int i) {
        sum += candidates[i];
        path.add(candidates[i]);

        if (sum == target) {
            ans.add(new LinkedList(path));
            path.removeLast();
            sum -= candidates[i];
            return;
        }

        // 剪枝
        if (sum > target) {
            path.removeLast();
            sum -= candidates[i];
            return;
        }
        // 确保使用大于等于当前index的值，不会出现重复
        for (int j = begin; j < candidates.length; j++) dfs(path, sum, j, j);
        path.removeLast();
        sum -= candidates[i];
    }
}