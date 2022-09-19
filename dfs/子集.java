class Solution {
    List<List<Integer>> ans = new ArrayList();
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        LinkedList<Integer> path = new LinkedList();
        ans.add(new LinkedList());
        for (int i = 0; i < nums.length; i++)
            dfs(i, path);
        return ans;
    }

    public void dfs(int start, LinkedList<Integer> path) {

        path.add(nums[start]);
        ans.add(new LinkedList(path));
        for (int i = start + 1; i < nums.length; i++)
            dfs(i, path);
        path.removeLast();


    }
}