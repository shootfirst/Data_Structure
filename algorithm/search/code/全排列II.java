class Solution {
    // https://leetcode.cn/problems/permutations-ii/
    List<List<Integer>> ans = new LinkedList();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        int [] visit = new int [n];
        LinkedList<Integer> path = new LinkedList();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) dfs(i, visit, path, nums);
        return ans;
    }

    private void dfs(int i, int[] visit, LinkedList<Integer> path, int[] nums) {
        if (visit[i] == 1) return;
        // 剪枝
        if (i > 0 && nums[i - 1] == nums[i] && visit[i - 1] == 0) return;


        path.add(nums[i]);
        if (path.size() == nums.length) {
            ans.add(new LinkedList(path));
            path.removeLast();
            return;
        }

        visit[i] = 1;
        for (int j = 0; j < nums.length; j++) dfs(j, visit, path, nums);
        path.removeLast();
        visit[i] = 0;
    }
}