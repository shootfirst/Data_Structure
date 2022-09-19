class Solution {
    List<List<Integer>> ans = new ArrayList();
    int[] nums;
    int[] visit;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        visit = new int[nums.length];
        LinkedList<Integer> path = new LinkedList();
        ans.add(new LinkedList());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
            dfs(i, path);
        return ans;
    }

    public void dfs(int start, LinkedList<Integer> path) {
        if (visit[start] == 1) return;
        // 剪枝
        if (start > 0 && visit[start - 1] == 0 && nums[start - 1] == nums[start]) return;
        path.add(nums[start]);
        visit[start] = 1;
        ans.add(new LinkedList(path));
        for (int i = start + 1; i < nums.length; i++)
            dfs(i, path);
        visit[start] = 0;
        path.removeLast();


    }
}