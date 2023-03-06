class Solution {
    int n;
    int [] visit;
    List<List<Integer>> ans;
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {

        n = nums.length;
        visit = new int [n];
        ans = new ArrayList();
        LinkedList<Integer> path = new LinkedList();
        this.nums = nums;

        for (int i = 0; i < n; i++) dfs(i, path);


        return ans;
    }

    private void dfs(int index, LinkedList<Integer> path) {
        // 没有被访问过，我们才进行访问
        if (visit[index] == 0) {
            path.addLast(nums[index]);
            // 到达其中一个终点，记录之
            if (path.size() == n) {
                ans.add(new LinkedList(path));
                // 恢复状态变量
                path.removeLast();
                return;
            }
            // 否则继续探索
            visit[index] = 1;
            for (int i = 0; i < n; i++) dfs(i, path);
            // 恢复状态变量
            visit[index] = 0;
            path.removeLast();
        }
    }
}